package com.example.blog.controllers;


import com.example.blog.services.AdService;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdsController {

    AdService adSvc;

    public AdsController(AdService adSvc) {
        this.adSvc = adSvc;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adSvc.getAllAds());
        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("ad", adSvc.getAd(id));
        return "/ads/show";
    }

    @GetMapping("/ads/create")
    @ResponseBody
    public String create() {
        return "Here is the ads create form...";
    }

    @PostMapping("/ads/create")
    @ResponseBody
    public String insert() {
        return "Inserted new ads!";
    }

}