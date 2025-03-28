package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class proxyContoller {

    private boolean req = false;
    @GetMapping("/lucasseq/{value}")
    @ResponseBody
    public String getSeq(@PathVariable("value") int value) throws IOException {
        String url1 = "http://3.87.198.120:8080/seq/" + value, url2 = "http://44.201.169.182:8080/seq/" + value, ulrRequest;
        ulrRequest = req ? url1 : url2;
        req = !req;
        return "{\n" +
                "\n" +
                " \"operation\": \"Secuencia de Lucas\",\n" +
                "\n" +
                " \"input\":  13,\n" +
                "\n" +
                " \"output\":" + HttpConnectionExample.request(ulrRequest) + "}";
        //return HttpConnectionExample.request("url1");
    }

    public String getIndex(){
        return "index";
    }



}
