package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    /**
     * 生成一个uuid
     */
    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * 生成一个Jwt令牌
     */
    @Test
    public void testGenJwt(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","Tom");
        String jwt = Jwts.builder()
                .setClaims(claims)//自定义内容（载荷）
                .signWith(SignatureAlgorithm.HS256, "itheima")//指定签名算法
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))//有效期
                .compact();
        System.out.println(jwt);

    }

    /**
     * 解析Jwt令牌
     */
    @Test
    public void parseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")//指定签名秘钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzY2MDA4Nzc1LCJ1c2VybmFtZSI6IlRvbSJ9.69ZaebeEgs4lAi2TUau1BEaKnDXn5zELuUl8auubnRU")
                .getBody();
        System.out.println(claims);
    }
}
