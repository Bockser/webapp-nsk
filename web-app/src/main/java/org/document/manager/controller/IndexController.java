package org.document.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Администратор on 01.12.2017.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    private String getIndex() {
        return "index";
    }
}
