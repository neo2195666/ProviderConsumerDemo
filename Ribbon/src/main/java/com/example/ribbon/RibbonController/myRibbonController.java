package com.example.ribbon.RibbonController;

import com.example.ribbon.Services.MyRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myRibbonController {
    @Autowired
    private MyRibbonService myRibbonService;

    @GetMapping("/test")
    public String test1(){
        myRibbonService.test();
        return "Ribbon";
    }
}
