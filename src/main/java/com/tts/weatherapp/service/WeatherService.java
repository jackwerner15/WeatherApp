package com.tts.weatherapp.service;

import java.util.List;

import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.ZipCode;
import com.tts.weatherapp.repository.ZipCodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private ZipCodeRepository zipcodeRepository; 

    
    @Value("${api_key}")
    private String apiKey;

    public List<ZipCode> getForecast() {
        return (List<ZipCode>) zipcodeRepository.findAll();
 
    }


    // Make a call to openweather api, with dynamic zipcode and apikey
    public Response getForecast(String zipCode){
        
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        try{
        return restTemplate.getForObject(url, Response.class);
        }catch(HttpClientErrorException exception){
            Response response = new Response();
            response.setName("ERROR");
            return response;
        }
    }

    private void recentSearch(List<ZipCode> zipCodes){
        
    }
    
}
