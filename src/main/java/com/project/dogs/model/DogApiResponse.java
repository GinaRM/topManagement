package com.project.dogs.model;

import java.util.List;
import java.util.Map;

public class DogApiResponse {
    private String status;
    private Map<String, List<String>> message;


    public Map<String, List<String>> getMessage() {
        return message;
    }


}
