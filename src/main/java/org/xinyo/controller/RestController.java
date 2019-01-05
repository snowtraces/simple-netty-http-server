package org.xinyo.controller;

import com.google.gson.Gson;
import org.xinyo.annotation.RestMapping;

import java.util.HashMap;
import java.util.Map;

public class RestController {

    @RestMapping("/data")
    public String data(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 21);
        map.put("phone", "15212345678");
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
