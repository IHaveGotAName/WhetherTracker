import com.podd.WeatherTracker.dto.CityDTO;
import com.podd.WeatherTracker.dto.UserDTO;
import com.podd.WeatherTracker.services.impl.CityService;
import com.podd.WeatherTracker.services.impl.UserService;
import com.podd.WeatherTracker.utilities.Parser;
import com.podd.WeatherTracker.utilities.WeatherRequest;
import com.podd.WeatherTracker.utilities.WeatherResponse;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.podd.WeatherTracker.utilities.Parser;

/**
 * Created by ivegotaname on 15.03.17.
 */

public class GsonTest {

        private static final String CITY_ID = "709930"; // Dnipro
        private static final Gson gson = new GsonBuilder().create();

    public static void main(String[] args) {
        String weatherJson = WeatherRequest.getRawWeather(CITY_ID);
        WeatherResponse now = gson.fromJson(weatherJson, WeatherResponse.class);
        Parser parser = new Parser();
        parser.getWeatherParser(now);


    }
}
