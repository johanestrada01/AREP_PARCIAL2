package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/seq")
public class proxyContoller {

    String response;
    HashMap<Integer, Integer> values = new HashMap<>();
    @GetMapping("/lucasseq/{value}")
    @ResponseBody
    public String getSeq(@PathVariable("value") int value) throws IOException {
        boolean req = false;
        String url1 = "http://3.87.198.120:8080/seq/" + value, url2 = "http://44.201.169.182:8080/seq/" + value, ulrRequest;
        ulrRequest = req ? url1 : url2;
        req = !req;
        return ulrRequest;
        return "{\n" +
                "\n" +
                " \"operation\": \"Secuencia de Lucas\",\n" +
                "\n" +
                " \"input\":  13,\n" +
                "\n" +
                " \"output\":" + HttpConnectionExample.request(ulrRequest) + "}";
    }


    public int calculateValue(int value){
        if(!values.containsKey(value)){
            values.put(value, calculateValue(value-1) + calculateValue(value-2));
            return values.get(value);
        }
        else {
            return values.get(value);
        }
    }

}
