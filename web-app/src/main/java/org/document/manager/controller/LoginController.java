package org.document.manager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Администратор on 01.12.2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView getLoginForm(HttpServletRequest request,
                                     HttpServletResponse response,
                                     @RequestParam(value = "error", required = false) String error,
                                     @RequestParam(value = "logout", required = false) String logout) throws Exception {

        ModelAndView model = new ModelAndView("login");
        if (error != null) {
            model.addObject("error", "Неверный логин или пароль!");
        }

        if (logout != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            model.addObject("msg", "Вы вышли.");
        }
        return model;
    }
}
