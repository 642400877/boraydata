package com.boraydata.hygiene.dal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommonMapper {

    @Update("drop table if exists population")
    void dropPopulationTable();

    @Update("drop table if exists economics")
    void dropEconomicsTable();

    @Update("CREATE TABLE `population` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `population_number` int(11) DEFAULT NULL COMMENT '人口数量',\n" +
            "  `place_name` varchar(50) DEFAULT NULL COMMENT '地区名称',\n" +
            "  `birth_number` int(11) DEFAULT NULL COMMENT '出生人数',\n" +
            "  `birth_rate` float(5,2) DEFAULT NULL COMMENT '出生率',\n" +
            "  `mortality_number` int(11) DEFAULT NULL COMMENT '死亡人数',\n" +
            "  `mortality` float(5,2) DEFAULT NULL COMMENT '死亡率',\n" +
            "  `data_time` datetime DEFAULT NULL COMMENT '数据日期',\n" +
            "  `migration_index` float(5,2) DEFAULT NULL COMMENT '人口迁移指数',\n" +
            "  `population_density` float(5,2) DEFAULT NULL COMMENT '人口稠密度',\n" +
            "  `spread` int(11) DEFAULT NULL COMMENT '疫情扩散曲线',\n" +
            "  `cure_rate` float(5,2) DEFAULT NULL COMMENT '治愈率',\n" +
            "  `spread_rate` float(5,2) DEFAULT NULL COMMENT '传播率',\n" +
            "  `infected_mortality` float(5,2) DEFAULT NULL COMMENT '因感染死亡率',\n" +
            "  `infected_death_number` float(5,2) DEFAULT NULL COMMENT '因感染死亡数量',\n" +
            "  `total_increase` int(11) DEFAULT NULL COMMENT '总新增感染人数',\n" +
            "  `local_increase` int(11) DEFAULT NULL COMMENT '本土新增',\n" +
            "  `asymptomatic` int(11) DEFAULT NULL COMMENT '无症状感染',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '创建日期',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT '更新日期',\n" +
            "  `delete_type` tinyint(3) DEFAULT NULL COMMENT '删除状态',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `index_place_name` (`place_name`) USING BTREE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1530 DEFAULT CHARSET=utf8mb4;")
    void createPopulationTable();

    @Update("CREATE TABLE `economics` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `place_name` varchar(50) DEFAULT NULL,\n" +
            "  `gdp` int(11) DEFAULT NULL,\n" +
            "  `cpi` int(11) DEFAULT NULL,\n" +
            "  `social_fixed_assets` int(11) DEFAULT NULL COMMENT '社会固定资产',\n" +
            "  `revenue` int(11) DEFAULT NULL COMMENT '财政收入',\n" +
            "  `budget` int(11) DEFAULT NULL COMMENT '财政预算',\n" +
            "  `speed_increase` float(5,2) DEFAULT NULL COMMENT '增速',\n" +
            "  `loss` int(11) DEFAULT NULL COMMENT '经济损失',\n" +
            "  `data_time` datetime DEFAULT NULL COMMENT '数据日期',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '创建日期',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT '更新日期',\n" +
            "  `delete_type` tinyint(3) DEFAULT NULL COMMENT '状态',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `index_place_name` (`place_name`) USING BTREE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8mb4;")
    void createEconomicsTable();

}
