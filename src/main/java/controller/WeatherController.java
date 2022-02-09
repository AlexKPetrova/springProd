package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import service.WeatherService;

import java.io.IOException;
import java.util.Collections;

@RestController
public class WeatherController {

    //api.openweathermap.org/data/2.5/weather?lat=55&lon=49&appid=50da205a9c76cfaf41a554bc57768910

    private final WeatherService weatherService;
   // public RestTemplate restTemplate;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


//    @RequestMapping(value = "/test")
//    public String test()
//    {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        return restTemplate.exchange("api.openweathermap.org/data/2.5/weather?lat=55&lon=49&appid=50da205a9c76cfaf41a554bc57768910", HttpMethod.GET, entity, String.class).getBody();
//    }


    @GetMapping("/weather")
    public String hello(){

        return weatherService.getData();
    }


}
