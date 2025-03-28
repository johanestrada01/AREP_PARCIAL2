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
        String url1 = "a", url2 = "null", ulrRequest;
        ulrRequest = req ? url1 : url2;
        req = !req;
        return ulrRequest;
        //return HttpConnectionExample.request("url1");
    }

    public String getIndex(){
        return "index";
    }



}
