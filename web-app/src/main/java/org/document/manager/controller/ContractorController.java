package org.document.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/contractor/")
public class ContractorController {

    @GetMapping
    public ModelAndView getIndex() {
        return new ModelAndView("contractor/index");
    }
}
