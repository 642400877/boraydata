package com.boraydata.hygiene.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private static final String KEY = "token" ;	//盐

    private static final int EXPIRE_TIME =  3600000; //过期时间  毫秒

    /**
     * 生成JWT
     *
     * @param id
     * @param subject
     * @return
     */
    public static String createJWT(String id, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, KEY);
        if (EXPIRE_TIME > 0) {
            builder.setExpiration( new Date( nowMillis + EXPIRE_TIME));
        }
        return "Bearer " + builder.compact();
    }

    /**
     * 解析JWT
     * @param jwtStr
     * @return
     */
    public static Claims parseJWT(String jwtStr){
        return  Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(jwtStr)
                .getBody();
    }

}
