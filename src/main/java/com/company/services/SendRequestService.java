package com.company.services;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Iterator;

@Service
public class SendRequestService {
    public void send() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/getInfo";
        System.out.println("before");
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl , String.class);
        System.out.println(response.getStatusCode());

        System.out.println("Answer "+response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        Iterator<JsonNode> iterator = root.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().asText());
        }
    }
}
