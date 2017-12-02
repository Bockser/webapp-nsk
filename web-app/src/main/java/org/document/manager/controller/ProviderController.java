package org.document.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/provider/")
public class ProviderController {

    @GetMapping
    public ModelAndView getIndex(){
        return new ModelAndView("provider/index");
    }
}
