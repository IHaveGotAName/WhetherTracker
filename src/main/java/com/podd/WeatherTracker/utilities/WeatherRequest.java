package com.podd.WeatherTracker.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/**
 * Created by ivegotaname on 15.03.17.
 */
public class WeatherRequest {


        private static final String APP_ID = "ca3373cd5365bf5314541a446f195f73";
        private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&APPID=" + APP_ID + "&id=";
        private static final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?units=metric&APPID=" + APP_ID + "&id=";

        private static String getRawJson(final String whereUrl) {
            StringBuilder result = null;
            String line;
            URL url;
            URLConnection conn;
            BufferedReader in = null;

            try {
                url = new URL(whereUrl);
                conn = url.openConnection();
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                result = new StringBuilder();
                while ( (line = in.readLine()) != null ) {
                    result.append(line);
                }

            } catch (MalformedURLException ex) {
                System.err.println(ex);
            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        System.err.println(ex);
                    }
                }
            }

            return result != null? result.toString() : null;
        }

        public static String getRawWeather(final String cityId){
            return getRawJson(WEATHER_URL + cityId);
        }

        public static String getRawForecast(final String cityId){
            return getRawJson(FORECAST_URL + cityId);
        }
    }

