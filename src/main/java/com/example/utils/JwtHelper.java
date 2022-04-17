package com.example.utils;

import java.util.HashMap;
import java.util.Map;

/*
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
*/

import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;  



import io.jsonwebtoken.Claims;  
import io.jsonwebtoken.JwtBuilder;  
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;  


/**
 * jwt helper
 * @author longenyue create on 2017-05-08
 *
 */
public class JwtHelper {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtHelper.class);
	/**
	 * 由字符串生成加密key
	 * @return
	 */
	public SecretKey generalKey(){
		String stringKey = Constant.JWT_SECRET;
		byte[] encodedKey = Base64.decodeBase64(stringKey);
	    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
	    return key;
	}

	/**
	 * 创建jwt
	 * @param id
	 * @param subject
	 * @param ttlMillis
	 * @return
	 * @throws Exception
	 */
	public String createJWT( Map<String, Object> claims,long ttlMillis) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = generalKey();
		
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("typ", "JWT");
		headerMap.put("alg", "HS256");
		
		JwtBuilder builder = Jwts.builder()
				.setHeader(headerMap)	//header
				.setIssuer("ggkj")   //该JWT的签发者
				.setIssuedAt(now)    //在什么时候签发的
				.setClaims(claims)   //传递的数据
				.signWith(signatureAlgorithm, key);
		if (ttlMillis >= 0) {
		    long expMillis = nowMillis + ttlMillis;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp);
		}
		return builder.compact();
	}
	
	/**
	 * 解密jwt
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public Claims parseJWT(String jwt){
		try{
			SecretKey key = generalKey();
			Claims claims = Jwts.parser()         
					.setSigningKey(key)
					.parseClaimsJws(jwt).getBody();
			return claims;
		}catch(Exception e){
			logger.debug("解析jwt失败，失败原因：" + e.getMessage());
			System.out.println("解析jwt失败，失败原因：" + e.getMessage());
			return null;
		}
	}

	/*
    public static void main( String[] args )
    {
    	JwtHelper jwt = new JwtHelper();
    	String s;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("username", "longenyue");
			map.put("mobile", "13998360970");
			s = jwt.createJWT(map,20000);
			System.out.println(s);			
			Claims c = jwt.parseJWT(s);
			if(c != null){
				System.out.println("username:" + c.get("username"));
				System.out.println("mobile:" + c.get("mobile"));
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
    }
    */
}
