package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.PopulationService;
import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.PopulationRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class PopulationBusiness {

    @Autowired
    PopulationService populationService;

    @Transactional(rollbackFor = Exception.class)
    public List<PopulationEntity> populationInfo(PopulationRequest populationRequest) {
        populationService.findPopulationInfoExist(populationRequest);
        return populationService.listMainPopulation(populationRequest);
    }

    @Transactional(rollbackFor = Exception.class)
    //数据库中查找指定条数数据，不够就动态生成
    public List<PopulationEntity> listPopulationInfo(PopulationRequest populationRequest) throws BusinessException, NoSuchFieldException, IllegalAccessException {

        String placeName = populationRequest.getPlaceName();
        Integer size = populationRequest.getSize();

        if (size<=0){
            return  new ArrayList<>();
        }

        List<PopulationEntity> populationEntityList = populationService.listMainPopulation(populationRequest);
        int queryNum = populationEntityList.size();
        int insertNumber = size - queryNum;

        if (queryNum == 0 && size > 0){//数据库中没有数据，根据注解随机生成数据
            try {
                //先用注解生成一条随机数据
                PopulationEntity newPopulationEntity = this.addPopulationByAnnotation(placeName);
                //根据随机数据动态生成数据
                List<PopulationEntity> populationEntities = this.addPopulationByLastEntity(placeName, size - 1, newPopulationEntity);

                populationEntities.add(0,newPopulationEntity);

                //将动态生成的数据插入数据库
                populationService.addPopulationInfo(populationEntities);
                //将数据插入到结果集
                populationEntityList.addAll(populationEntities);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new BusinessException("数据插入失败");
            }
        }else if (insertNumber <= 0){//数据足够，直接返回
            return populationEntityList.subList(0,size);
        }else if(insertNumber > 0 && size > 0){//数据库中有数据，但数量不足
            List<PopulationEntity> populationEntities = this.addPopulationByLastEntity(
                    placeName,
                    size - queryNum,
                    populationEntityList.get(queryNum - 1)
            );
            populationService.addPopulationInfo(populationEntities);
            populationEntityList.addAll(populationEntities);
        }else{
            throw new BusinessException("输入数据有误");
        }
        return populationEntityList;
    }

    /**
     * 根据地名通过注解动态生成一条不存在的数据
     * placeName:地名
     * return:地名为placeName的实例对象
     * */
    public PopulationEntity addPopulationByAnnotation(String placeName) throws NoSuchFieldException, IllegalAccessException {
        Random rand = new Random();
        Field[] fields = PopulationEntity.class.getDeclaredFields();
        PopulationEntity populationEntity = new PopulationEntity();
        for (int i = 0; i < fields.length; i++) {
            Field field = populationEntity.getClass().getDeclaredField(fields[i].getName());
            RandomAnnotation randomAnnotation = field.getAnnotation(RandomAnnotation.class);
            if (randomAnnotation != null) {
                double num  = rand.nextInt(randomAnnotation.max()) + randomAnnotation.min();
                if (randomAnnotation.needFloat()) {
                    num  = num / Math.pow(10, randomAnnotation.floatNumber());
                }
                field.setAccessible(true);
                if("class java.lang.Integer".equals(field.getGenericType().toString())) {
                    field.set(populationEntity, (int)num);
                } else if("class java.lang.Float".equals(field.getGenericType().toString())) {
                    field.set(populationEntity, (float)num);
                } else if("class java.lang.Long".equals(field.getGenericType().toString())) {
                    field.set(populationEntity, (long)num);
                } else {
                    field.set(populationEntity, num);
                }
            }
        }
        populationEntity.setPlaceName(placeName);
        return  populationEntity;
    }

    /**
     * 通过最新的一条数据动态生成size条新的数据，并插入到数据库中
     * placeName:地名
     * size:要生成数据的数量
     * lastPopulationEntity:最新一条的数据
     * */
    public List<PopulationEntity> addPopulationByLastEntity(String placeName,Integer size,PopulationEntity copyPopulationEntity) throws NoSuchFieldException, IllegalAccessException {
        Random rand = new Random();
        List<PopulationEntity> newPopulationEntities = new ArrayList<>();
        PopulationEntity populationEntity;
        PopulationEntity lastPopulationEntity = new PopulationEntity();
        BeanUtils.copyProperties(copyPopulationEntity,lastPopulationEntity);
        for (int j = 0; j < size; j++) {
            populationEntity = new PopulationEntity();
            Field[] fields = PopulationEntity.class.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = populationEntity.getClass().getDeclaredField(fields[i].getName());
                RandomAnnotation randomAnnotation = field.getAnnotation(RandomAnnotation.class);
                if (randomAnnotation != null) {
                    field.setAccessible(true);
                    double num  = rand.nextInt(randomAnnotation.maxFloat()+
                            Math.abs(randomAnnotation.minFloat())) - Math.abs(randomAnnotation.minFloat());
                    if (randomAnnotation.needFloat()) {
                        num  = num / Math.pow(10, randomAnnotation.floatNumber());
                    }
                    if("class java.lang.Integer".equals(field.getGenericType().toString())) {
                        int oldNum = (int) field.get(lastPopulationEntity);
                        while (oldNum + (int)num < 0){
                            num  = rand.nextInt(randomAnnotation.maxFloat()+
                                    Math.abs(randomAnnotation.minFloat())) - Math.abs(randomAnnotation.minFloat());
                            if (randomAnnotation.needFloat()) {
                                num  = num / Math.pow(10, randomAnnotation.floatNumber());
                            }
                        }
                        field.set(populationEntity, oldNum + (int)num);
                    } else if("class java.lang.Float".equals(field.getGenericType().toString())) {
                        float oldNum = (float) field.get(lastPopulationEntity);
                        while (oldNum + (float)num < 0){
                            num  = rand.nextInt(randomAnnotation.maxFloat()+
                                    Math.abs(randomAnnotation.minFloat())) - Math.abs(randomAnnotation.minFloat());
                            if (randomAnnotation.needFloat()) {
                                num  = num / Math.pow(10, randomAnnotation.floatNumber());
                            }
                        }
                        field.set(populationEntity, oldNum + (float)num);
                    } else if("class java.lang.Long".equals(field.getGenericType().toString())) {
                        double oldNum = (double) field.get(lastPopulationEntity);
                        while (oldNum + num < 0){
                            num  = rand.nextInt(randomAnnotation.maxFloat()+
                                    Math.abs(randomAnnotation.minFloat())) - Math.abs(randomAnnotation.minFloat());
                            if (randomAnnotation.needFloat()) {
                                num  = num / Math.pow(10, randomAnnotation.floatNumber());
                            }
                        }
                        field.set(populationEntity, oldNum + num);
                    } else {
                        field.set(populationEntity, num);
                    }
                }
            }
            populationEntity.setPlaceName(placeName);
            //将生成的数据插入列表
            newPopulationEntities.add(populationEntity);
            //更新最新值
            BeanUtils.copyProperties(populationEntity,lastPopulationEntity);
        }
        return newPopulationEntities;
    }

}
