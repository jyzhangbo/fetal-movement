package com.github.controller;

import com.github.model.FetalInfo;
import com.github.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * zhangbo
 */
@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("/")
    public String home(Model model){

        List<FetalInfo> infos = homeService.home();
        model.addAttribute("infos",infos);

        return "index";
    }

    @RequestMapping("/fetal")
    public String fetal(Integer count){

        homeService.fetal(count);

        return "redirect:/";
    }

}
