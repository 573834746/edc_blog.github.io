package com.blog.orderserver01.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *  动态盐的MD5加密
 *
 *
 *  ########################################################################
 *  =========动态盐的生成
 *
 *  使用随机数生成，使用 SecureRandom 类，生成随机数；生成的随机数填充在字节数组中，然后将字节数组转成字符串，转之前，同样进行一次转换，将它们全部转成0-9、a-f的字符串；
 *
 *  转到时候，需要注意下，为了控制盐的最终长度，对小于16的数值，进行了加16，为了得到2位数的16进制，得到动态盐；
 *
 *  将盐加在密码屁股后面，进行一个MD5加密，得到加密的字符串
 *
 *  将动态盐嵌套到返回的加密字符串中，为了下次验证试验；
 *
 *  嵌套的时候，注意奇数位是密码，偶数位是盐，由于之前控制了盐的长度是24，MD5经过Base64编码的长度也是24；（其中 Base64 编码的长度：设字符串长度为n ，长度为 ⌈n/3⌉*4 ⌈⌉ 代表上取整）
 *
 *  由于控制了长度是固定的48位，因此，嵌套的时候，很容易嵌套；
 *
 *  ==========验证
 *
 *  从给定的加密的字符串中获取当时的动态盐、加盐的MD5字符串，根据当初嵌套的规则取；
 *
 *  然后将传入的密码，用加密的盐混合一下，再MD5，进行比对，即可得知密码是否一致；
 *
 *  ##########################################################################
 *
 *
 * @author XSY
 */
@SuppressWarnings("unused")
public class Md5Util {


    @SuppressWarnings("unused")
    /**
     * 普通MD5,只是实现下，这里不推荐使用，虽然是不可逆的，但是聪明的人想到了查表，导致普通MD5的安全壁垒 GG 了；
     * @author XSY
     * @return 加密的字符
     */
    public static String MD5(String input) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "JDK不支持该算法，检查下JDK";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = input.getBytes();

        byte[] md5Bytes = md5.digest(byteArray);

        System.out.println( new BASE64Encoder().encode(md5Bytes));
        StringBuffer hexValue = new StringBuffer();
        //     将加密完的字符串，全部转成0-9、a-f的字符串
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
        //     如果小于16，也就是16进制只有1位的情况下。前面补0
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }


    /**
     * 加盐MD5
     *
     * @param password 原始密码
     * @return 加盐的MD5字符串
     * @author XSY
     */
    public static String generateDynamicSaltMd5(String password) {
//        生成随机盐，长度12位
        byte[] bytes = new byte[12];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);

        StringBuilder builder = new StringBuilder();
//        将字节数组变为字符串
        for (int i = 0; i < bytes.length; i++) {
//            将生成的值，全部映射到0-255 之间
            int val = ((int) bytes[i]) & 0xff;
            if (val < 16) {
//                为了控制盐的长度，这里小于16 的值，我们将它补为 大于16的值；
//                这样，生的盐的长度是固定的：bytes * 2 ;
                builder.append(Integer.toHexString(val + 16));
            } else {
                builder.append(Integer.toHexString(val));
            }
        }

//        最终的盐，长度是 12*2 = 24 ；
        String salt = builder.toString();


//        先加盐Md5一把，再将 MD5 转换成 24位的 base64 位编码
        password = md5Hex(password + salt);

        char[] cs = new char[salt.length() + password.length()];

        for (int i = 0; i < cs.length; i += 4) {

//            密码编码
            cs[i] = password.charAt(i / 2);
            cs[i + 2] = password.charAt(i / 2 + 1);
//            盐编码
            cs[i + 1] = salt.charAt(i / 2);
            cs[i + 3] = salt.charAt(i / 2 + 1);

        }
        return new String(cs);
    }

    /**
     * 校验加盐后是否和原文一致
     *
     * @param password
     * @param md5
     * @return true 代表密码验证通过
     * @author XSY
     */
    public static boolean verify(String password, String md5) {
//        解码密码
        char[] cs1 = new char[24];
//        解码盐
        char[] cs2 = new char[24];
//        从MD5 中取出盐
        for (int i = 0; i < md5.length(); i += 4) {
//            取出盐
            cs2[i / 2] = md5.charAt(i + 1);
            cs2[i / 2 + 1] = md5.charAt(i + 3);
//            取出密码的MD5值（经过Base64转换后的MD5）
            cs1[i / 2] = md5.charAt(i + 0);
            cs1[i / 2 + 1] = md5.charAt(i + 2);
        }

        String salt = new String(cs2);

        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new BASE64Encoder().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

}