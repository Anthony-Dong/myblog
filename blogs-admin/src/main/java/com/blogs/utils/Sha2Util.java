package com.blogs.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * ClassName:Sha2Util
 * Package:com.dubbo.user.utils
 * Description:
 *
 * @date:2019/8/11 22:49
 * @author: 574986060@qq.com
 */

public class Sha2Util {


    public static String generateKey(String password, String salt) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(password).append(salt);

        return DigestUtils.sha256Hex(DigestUtils.sha1Hex(stringBuilder.toString()));
    }


    public static String  generateSalt(){
       return UUID.randomUUID().toString();
    }


    public static void main(String[] args) {

        System.out.println(getRes(7));
        System.out.println(1*2*3*4*5*6*7*8*9*10);
        System.out.println(1*2*3*4*5*6*7*8*9*10*11);
        System.out.println(1*2*3*4*5*6*7*8*9*10*11*12);

    }


    public static  Integer getRes(Integer num){
        double target =  Math.pow(10, num);
        int sum = 1;
        int nums = 0;
        while (sum < target) {
            nums++;
            sum *= nums;
        }
        return nums-1;
    }





}
