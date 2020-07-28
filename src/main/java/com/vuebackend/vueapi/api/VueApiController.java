package com.vuebackend.vueapi.api;

import com.vuebackend.vueapi.common.ResponseModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vue")
public class VueApiController {

    private static List<String> lunboList=new ArrayList<>();

    static {
        lunboList.add("http://129.204.127.180:9999/pic/1.png");
        lunboList.add("http://129.204.127.180:9999/pic/2.png");
        lunboList.add("http://129.204.127.180:9999/pic/3.png");
        lunboList.add("http://129.204.127.180:9999/pic/4.png");
        lunboList.add("http://129.204.127.180:9999/pic/5.png");
        lunboList.add("http://129.204.127.180:9999/pic/6.png");
        lunboList.add("http://129.204.127.180:9999/pic/7.png");
        lunboList.add("http://129.204.127.180:9999/pic/8.png");
    }

    @GetMapping("/lunbo")
    @CrossOrigin
    public Object getLunboImg(){
        return ResponseModel.getSuccessResponse(lunboList);
    }
}
