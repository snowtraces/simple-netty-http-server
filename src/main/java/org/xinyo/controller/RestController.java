package org.xinyo.controller;

import com.google.gson.Gson;
import org.xinyo.annotation.Param;
import org.xinyo.annotation.Reference;
import org.xinyo.annotation.RestMapping;
import org.xinyo.entity.Person;
import org.xinyo.service.Service;

public class RestController {

    @Reference
    private Service service;

    @RestMapping("/data")
    public String data(@Param("name") String name, Person person){
        service.test(person);
        Gson gson = new Gson();
        return gson.toJson(person);
    }
}
