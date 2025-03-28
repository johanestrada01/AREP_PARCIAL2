package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/seq")
public class proxyContoller {

    String response;
    HashMap<Integer, Integer> values = new HashMap<>();
    @GetMapping("/{value}")
    public String getValue(@PathVariable("value") int value) throws IOException {
        values.put(0, 2);
        values.put(1, 1);
        calculateValue(value);
        return values.values().toString();
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
