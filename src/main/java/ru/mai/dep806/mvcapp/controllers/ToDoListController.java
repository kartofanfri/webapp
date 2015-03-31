package ru.mai.dep806.mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mai.dep806.mvcapp.dao.MockToDoListDao;

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
        model.addAttribute("titles", toDoListDao.getTitles());
        return PathJsp + "toDoList.jsp";
    }

    @RequestMapping(value = {"/todo.html", "/index.html", "/"}, method = RequestMethod.POST, params={"listTitle"})
    public String EditTitle(@RequestParam("listTitle") String listTitle,
                                Model model) {

        System.out.println(listTitle);

        toDoListDao.createList(listTitle);

        model.addAttribute("lists", toDoListDao.getToDoLists());
        model.addAttribute("titles", toDoListDao.getTitles());
        return PathJsp + "toDoList.jsp";
    }

    @RequestMapping(value = {"/todo.html", "/index.html", "/"}, method = RequestMethod.POST, params={"newListItem","ListNum"})
    public String EditTitle(@RequestParam("newListItem") String newListItem,
                            @RequestParam("ListNum") int idList,
                                Model model) {

        System.out.println(newListItem);
        System.out.println(idList);

        toDoListDao.addItem(idList,newListItem);

        model.addAttribute("lists", toDoListDao.getToDoLists());
        model.addAttribute("titles", toDoListDao.getTitles());
        return PathJsp + "toDoList.jsp";
    }

    @RequestMapping(value = {"/todo.html", "/index.html", "/"}, method = RequestMethod.POST, params={"newListItem","ListNum","chDel"})
    public String EditTitle(@RequestParam("newListItem") String newListItem,
                            @RequestParam("ListNum") int idList,
                            @RequestParam("chDel") String  chDel,
                            Model model) {

        System.out.println(newListItem);
        System.out.println(idList);
        System.out.println(chDel.split(" ")[0]);
        System.out.println(chDel.split(" ")[1]);
        int idItem = Integer.parseInt(chDel.split(" ")[1]);
        String action = chDel.split(" ")[0];


        if (action.equals("Del")){
            toDoListDao.deleteItem(idList,idItem);
        }else {
            toDoListDao.changeItem(idList,idItem,newListItem);
        }

        model.addAttribute("lists", toDoListDao.getToDoLists());
        model.addAttribute("titles", toDoListDao.getTitles());
        return PathJsp + "toDoList.jsp";
    }

    @RequestMapping(value = {"/todo.html", "/index.html", "/"}, method = RequestMethod.POST, params={"ListNum","delList"})
    public String EditTitle(@RequestParam("ListNum") int idList,
                            @RequestParam("delList") String  chDel,
                            Model model) {

        System.out.println("Del: "+idList);

        toDoListDao.deleteList(idList);

        model.addAttribute("lists", toDoListDao.getToDoLists());
        model.addAttribute("titles", toDoListDao.getTitles());
        return PathJsp + "toDoList.jsp";
    }
}
