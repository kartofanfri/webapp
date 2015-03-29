package ru.mai.dep806.mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер для главной страницы приложения.
 */
@Controller
public class WelcomeController {

    private int visitorCount = 0;

    @RequestMapping("/indexVC.html")
    public String index(Model model) {
        model.addAttribute("visitorCount", visitorCount++);
        return "WEB-INF/jsp/index.jsp";
    }

}