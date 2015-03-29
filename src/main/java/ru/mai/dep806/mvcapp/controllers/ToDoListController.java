package ru.mai.dep806.mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер для туду листа
 */
@Controller
public class ToDoListController {

    String PathJsp = "WEB-INF/jsp/";

    @RequestMapping(value = {"/todo.html","/index.html","/"})
    public String ShowToDoLists(Model model){
        return PathJsp + "toDoList.jsp";
    }
}
