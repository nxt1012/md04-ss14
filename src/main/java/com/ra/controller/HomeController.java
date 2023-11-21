package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller

public class HomeController {
    @RequestMapping("/")
    public String home(HttpSession httpSession, Model model) {
        String name = (String) httpSession.getAttribute("email");
        model.addAttribute("email", name);
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
