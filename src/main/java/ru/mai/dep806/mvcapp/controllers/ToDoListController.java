package ru.mai.dep806.mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mai.dep806.mvcapp.dao.MockToDoListDao;

import java.util.ArrayList;

/**
 * Контроллер для туду листа
 */
@Controller
public class ToDoListController {

    String PathJsp = "WEB-INF/jsp/";
    MockToDoListDao toDoListDao = new MockToDoListDao();

    @RequestMapping(value = {"/todo.html", "/index.html", "/"})
    public String ShowToDoLists(Model model) {



        model.addAttribute("lists", toDoListDao.getToDoLists());
        ArrayList<ArrayList<String>> fromDaoList = toDoListDao.getToDoLists();
        return PathJsp + "toDoList.jsp";
    }

    @RequestMapping(value = {"/todo.html", "/index.html", "/"}, method = RequestMethod.POST)
    public String EditToDoLists(@RequestParam("id") String login,Model model) {



        model.addAttribute("lists", toDoListDao.getToDoLists());
        ArrayList<ArrayList<String>> fromDaoList = toDoListDao.getToDoLists();
        return PathJsp + "toDoList.jsp";
    }
}
