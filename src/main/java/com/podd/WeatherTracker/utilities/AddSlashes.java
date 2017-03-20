package com.podd.WeatherTracker.utilities;

/**
 * Created by ivegotaname on 21.02.17.
 */
public class AddSlashes {
    public static String addSlashes(String s){
        s = s.replaceAll("\\\\", "\\\\\\\\");
        s = s.replaceAll("\\n", "\\\\n");
        s = s.replaceAll("\\r", "\\\\r");
        s = s.replaceAll("\\00", "\\\\0");
        s = s.replaceAll("'", "\\\\'");
        s = s.replaceAll("<", "\\<");
        s = s.replaceAll(">", "\\>");
        return s;
    }
}
