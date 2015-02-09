package com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ivan on 15-1-14.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public void showHomePage(Model model) {
        model.addAttribute("name","<a href='#'>Ivan</a>");
    }

}
