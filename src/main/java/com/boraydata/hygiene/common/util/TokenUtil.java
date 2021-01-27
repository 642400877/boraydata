package com.boraydata.hygiene.common.util;

import com.boraydata.hygiene.dal.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenUtil {

    private static final Integer EXPIRE_TIME = 3600000;

    private static final String KEY = "token";

    public static String creatToken(UserEntity userEntity){

        Date loginTime = new Date();	//登录时间
        Date limitTime = new Date(loginTime.getTime() + EXPIRE_TIME);	//设置过期时间为1分钟

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(String.valueOf(userEntity.getId()))  //用户id
                .setSubject(userEntity.getUsername())    //用户名
                .setIssuedAt(loginTime)//登录时间
                .signWith(SignatureAlgorithm.HS256,KEY)  //指定头和盐
                .setExpiration(limitTime);	//设置过期时间

        System.out.println(jwtBuilder.compact());//将jwtBuilder变成字符串
        return jwtBuilder.compact();
    }

    public boolean parseToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(KEY)  //盐
                .parseClaimsJws(token)	//需要解析的token
                .getBody();	  //返回一个Claims对象，里面是键值对

        System.out.println("用户id:"+claims.getId());
        System.out.println("用户昵称:"+claims.getSubject());
        System.out.println("用户登录时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        return true;
    }
}
