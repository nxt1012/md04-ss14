package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User user, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        if (userService.login(user)) {
            httpSession.setAttribute("email", user.getEmail());
            System.out.println("Đăng nhập thành công");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("err", "Sai thông tin đăng nhập");
        System.out.println("Đăng nhập thất bại");
        return "redirect:user/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        if (userService.save(user)) {
            System.out.println("Đăng ký thành công");
        }
        return "redirect:/user/login";
    }
}