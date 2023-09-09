package com.example.restapiassignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestApiAssignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApiAssignment2Application.class, args);
        randomFood();
        System.exit(0);
	}
        public static void randomFood() {
        try {
            String url = "https://random-data-api.com/api/food/random_food";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonPrice = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonPrice);

            //gets fact from api.
            String dish = root.findValue("dish").asText();
            String description = root.findValue("description").asText();

            //print dish.
            System.out.println("Dish name: " + dish);
            //print description.
            System.out.println("description : " + description);


        } catch (JsonProcessingException ex) {
            System.out.println("error in catFacts");
        }
    }

}
