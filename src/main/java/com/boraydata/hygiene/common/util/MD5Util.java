package com.boraydata.hygiene.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

public class MD5Util {

    public final static String KEY = "34ghfvenhfw.,fdsf";

    public final static String SALT_POOL = "qwertyuiopasdfghjklzxcvbnm1234567890";

    public static MD5CommonEntity md5(String text) throws Exception {
        Random random = new Random();
        MD5CommonEntity md5CommonEntity = new MD5CommonEntity();
        String salt = "";
        for (int i = 0; i < random.nextInt(3) + 3; i ++) {
            salt += MD5Util.SALT_POOL.charAt(random.nextInt(MD5Util.SALT_POOL.length()));
        }
        md5CommonEntity.setSalt(salt);
        md5CommonEntity.setMd5(DigestUtils.md5Hex(text + salt + MD5Util.KEY));
        return md5CommonEntity;
    }

    public static boolean verify(String text, String salt, String md5) throws Exception {
        String md5str = DigestUtils.md5Hex(text + salt + MD5Util.KEY);
        if (md5str.equalsIgnoreCase(md5)) {
            return true;
        }
        return false;
    }
}
