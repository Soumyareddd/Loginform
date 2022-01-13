package com.newproject.Loginform.controller;

import com.newproject.Loginform.domain.Login;
import com.newproject.Loginform.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    private LoginService userService;


    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {

        Login oauthUser = userService.login(user.getUsername(), user.getPassword());


        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {

            return "redirect:/";

        } else {
        	

            return "redirect:/login";

        }

    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {

        return "redirect:/login";
    }

}
