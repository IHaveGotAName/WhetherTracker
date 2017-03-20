package com.podd.WeatherTracker.utilities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 * Created by ivegotaname on 15.03.17.
 */
public class Parser {
    String dt;
    String id;
    String name;
    String weather_main;
    String weather_description;
    String icon;
    String temp;
    String temp_min;
    String temp_max;
    String humidity;
    String pressure;
    String wind_speed;
    String wind_degree;
    String clouds;
    String sunrise;
    String sunset;

    public String getDt() {
        return dt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWeather_main() {
        return weather_main;
    }

    public String getWeather_description() {
        return weather_description;
    }

    public String getIcon() {
        return icon;
    }

    public String getTemp() {
        return temp;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public String getWind_degree() {
        return wind_degree;
    }

    public String getClouds() {
        return clouds;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeather_main(String weather_main) {
        this.weather_main = weather_main;
    }

    public void setWeather_description(String weather_description) {
        this.weather_description = weather_description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setWind_degree(String wind_degree) {
        this.wind_degree = wind_degree;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    public Parser(){}
    public Parser ( String dt, String id, String name, String weather_main, String weather_description, String icon, String temp, String temp_min, String temp_max, String humidity, String pressure, String wind_speed, String wind_degree, String clouds, String sunrise, String sunset){
        this.dt = dt;
        this.id = id;
        this.name = name;
        this.weather_main = weather_main;
        this.weather_description = weather_description;
        this.icon = icon;
        this.clouds = clouds;
        this.icon = icon;
        this.temp = temp;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind_speed = wind_speed;
        this.wind_degree = wind_degree;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
    public Parser getWeatherParser(WeatherResponse string){
        Parser parser = new Parser();
        String pattern = "(.*):(.*)\n\t";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string.toString());
        ArrayList a = new ArrayList();
        while (m.find()) {
            a.add(m.group(2));
        }

        parser.setDt(a.get(0).toString());
        parser.setId(a.get(1).toString());
        parser.setName(a.get(2).toString());
        parser.setWeather_main(a.get(3).toString());
        parser.setWeather_description(a.get(4).toString());
        parser.setIcon(trim(a.get(5).toString()));
        parser.setTemp(a.get(6).toString());
        parser.setTemp_min(a.get(7).toString());
        parser.setTemp_max(a.get(8).toString());
        parser.setHumidity(a.get(9).toString());
        parser.setPressure(a.get(10).toString());
        parser.setWind_speed(a.get(11).toString());
        parser.setWind_degree(a.get(12).toString());
        parser.setClouds(a.get(13).toString());
/*        parser.setSunrise(a.get(14).toString());
        parser.setSunset(a.get(15).toString());*/

        return parser;
    }
}
