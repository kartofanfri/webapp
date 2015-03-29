package ru.mai.dep806.mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mai.dep806.mvcapp.dao.MockToDoListDao;

import java.util.ArrayList;
import java.util.List;

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
        for (List<String> forList : fromDaoList)
            for (String forStr : forList) {
                System.out.println(forStr);
            }

        return PathJsp + "toDoList.jsp";
    }
}
