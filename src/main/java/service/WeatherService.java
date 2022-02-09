package service;

import org.springframework.stereotype.Service;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class WeatherService {

    public String getData() {

        try {
            URL url = new URL("api.openweathermap.org/data/2.5/weather?lat=55&lon=49&appid=50da205a9c76cfaf41a554bc57768910");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            )) {
                StringBuilder content = new StringBuilder();
                String input;

                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                connection.disconnect();
                return content.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
