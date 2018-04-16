package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    @ResponseBody
        public  String sayHello() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}/{lastname}")
    @ResponseBody
    public String sayHello(@PathVariable String name, @PathVariable String lastname){
        return  "Hello World, " + name + " " + lastname;
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHelloFN(@PathVariable String name){
        return  "Hello World, " + name ;
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(){
        return "you have been logged out";
    }

    @RequestMapping(path = "/lights", method = RequestMethod.GET)
    @ResponseBody
    public String lights(){
        return "Lights on";
    }

    @PostMapping("/postExample")
    @ResponseBody
    public String testPost(@RequestParam String name) {
        return "Test Post Successful, name: " + name;
    }

}