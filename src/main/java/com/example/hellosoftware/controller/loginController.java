package com.example.hellosoftware.controller;

import com.example.hellosoftware.service.loginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class loginController {
    private  final loginService service;

    //로그인 창출력
    @GetMapping("/index")
    public void loginform() {

    }

    @PostMapping("/loginAction")
    public String loginAction(String id, String password, Model model, RedirectAttributes re) {
        int check = service.login(id,password);
        if(check == 1) {
            return "redirect:member/list";
        }else {
            return "redirect:/index?loginError=true";
        }
    }


}
