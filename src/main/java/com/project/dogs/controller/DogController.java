package com.project.dogs.controller;

import com.project.dogs.model.DogApiResponse;
import com.project.dogs.model.DogImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/breeds")
    public List<String> getBreeds() {
        String url = "https://dog.ceo/api/breeds/list/all";
        DogApiResponse response = restTemplate.getForObject(url, DogApiResponse.class);
        return new ArrayList<>(response.getMessage().keySet());
    }

    @GetMapping("/image/{breed}")
    public String getBreedImage(@PathVariable String breed) {
        String url = "https://dog.ceo/api/breed/" + breed + "/images/random";
        DogImageResponse response = restTemplate.getForObject(url, DogImageResponse.class);
        return Base64.getEncoder().encodeToString(response.getMessage().getBytes());
    }
}
