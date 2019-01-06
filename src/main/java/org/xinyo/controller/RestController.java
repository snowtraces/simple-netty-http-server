package org.xinyo.controller;

import com.google.gson.Gson;
import org.xinyo.annotation.Param;
import org.xinyo.annotation.RestMapping;
import org.xinyo.entity.Person;

public class RestController {

    @RestMapping("/data")
    public String data(@Param("name") String name, Person person){
        Gson gson = new Gson();
        return gson.toJson(person);
    }
}
