package com.example.songer.controller;

import com.example.songer.models.UserX;
import com.example.songer.repos.UserRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/login")
    String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    RedirectView login(HttpServletRequest request, UserX user) {
        UserX userFromDp = userRepo.findByUsername(user.getUsername());
        if (userFromDp != null  ) {
            if (BCrypt.checkpw(user.getPassword(), userFromDp.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());
                return new RedirectView("/");
            }
        }
        return new RedirectView("/login");
    }

    @PostMapping("/signup")
    RedirectView signup(UserX user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        userRepo.save(user);
        return new RedirectView("/login");
    }

    @PostMapping("/logout")
    RedirectView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return new RedirectView("/");
    }
}
