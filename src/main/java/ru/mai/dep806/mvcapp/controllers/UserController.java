package ru.mai.dep806.mvcapp.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import ru.mai.dep806.mvcapp.dao.MockUserDao;
import ru.mai.dep806.mvcapp.model.User;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Контроллер для работы с пользователями.
 */
@Controller
public class UserController {
    private MockUserDao userDao = new MockUserDao();

    @RequestMapping("/users.html")
    public ModelAndView listUsers() {
        return new ModelAndView("WEB-INF/jsp/users.jsp", "users", userDao.getAllUsers());
    }

    @RequestMapping(value = "/addUser.html", method = RequestMethod.GET)
    public String showCreateUser(Model model) {
        User user = new User();
        user.setActive(true);
        model.addAttribute("user", user);
        return "WEB-INF/jsp/addEditUser.jsp";
    }

    @RequestMapping(value = "/addUser.html", method = RequestMethod.POST)
    public String addUser(@RequestParam("login") String login,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("active") Boolean active,
                             ModelMap model) {
        User newUser = new User(login,name,email,new Date(),active);
        userDao.saveUser(newUser);
        model.addAttribute("user", newUser);
        return "WEB-INF/jsp/result.jsp";
    }

    @RequestMapping(value = "/editUser.html", method = RequestMethod.GET)
    public String showEditUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userDao.findUserById(id));
        return "WEB-INF/jsp/addEditUser.jsp";
    }

    @RequestMapping(value = "/editUser.html",headers="content-type=*", method = RequestMethod.POST)
    public String editUser(@RequestHeader("Accept-Encoding") String userAgent,
                           @RequestParam("login") String login,
                          @RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("active") Boolean active,
                          ModelMap model) {
        userDao.findUserById(0l).changeUser(login, name, email, new Date(), active);
        model.addAttribute("user", userDao.findUserById(0l));
        System.out.println(userAgent);
        return "WEB-INF/jsp/result.jsp";
    }


}