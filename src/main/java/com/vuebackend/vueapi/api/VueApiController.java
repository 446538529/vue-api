package com.vuebackend.vueapi.api;

import com.vuebackend.vueapi.common.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vue")
@CrossOrigin
@Slf4j
public class VueApiController {

    private static List<String> lunboList=new ArrayList<>();

    @Autowired
    private RestTemplate restTemplate;

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
    public Object getLunboImg(){
        return ResponseModel.getSuccessResponse(lunboList);
    }
    @GetMapping("/news")
    public Object getNewsList(){
        ResponseEntity<Map> entity = restTemplate.getForEntity("http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html", Map.class);
        List<Map<String,Object>> result=new ArrayList<>();
        ((List)entity.getBody().get("T1348647853363")).forEach(item->{
            Map<String,Object> map= (Map<String,Object>)item;
            Map<String,Object> newMap=new HashMap<>();
            newMap.put("id",map.get("docid"));
            newMap.put("title",map.get("title").toString());
            newMap.put("src",map.get("imgsrc"));
            newMap.put("createTime",map.get("ptime"));
            newMap.put("votecount",map.get("votecount"));
            newMap.put("summary",map.get("digest"));
            result.add(newMap);
        });
        return ResponseModel.getSuccessResponse(result);
    }


}
