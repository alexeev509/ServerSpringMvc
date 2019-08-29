package com.company.controllers;

import com.company.entity.User;
import com.company.services.SendRequestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private SendRequestService sendRequestService;

    @RequestMapping("/")
    public void startPage() {
        System.out.println("hi");
    }


    @RequestMapping("/sendRequest")
    public void getAndSend() throws IOException {
        System.out.println("hi");
        sendRequestService.send();
    }

    @RequestMapping(value = "/getInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getInfo() {
        System.out.println("return Answer");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.valueToTree(new User(45, "Bill"));

        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("age", 45);
        objectNode1.put("name", "Bill");
        return objectNode1.toString();
    }
}
