package com.example.md04_ss08_bai2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/api/math/divide")
    public int divideMath(@RequestParam int a, @RequestParam int b){
        return a/b;
    }
}
