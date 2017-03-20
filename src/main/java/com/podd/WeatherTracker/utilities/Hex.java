package com.podd.WeatherTracker.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Created by ivegotaname on 21.02.17.
 */


public class Hex {
    public static String hexSHA512(String passwordToHash){
        String generatedPassword = null;
        String salt = "simple";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
