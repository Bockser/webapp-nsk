package org.document.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/agent/")
public class AgentController {

    @GetMapping
    public ModelAndView getIndex() {
        return new ModelAndView("agent/index");
    }
}
