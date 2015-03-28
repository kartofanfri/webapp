package ru.mai.dep806.mvcapp.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import ru.mai.dep806.mvcapp.dao.MockUserDao;
import ru.mai.dep806.mvcapp.model.User;
//import ru.mai.dep806.mvcapp.dao.MockUserDao;

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

    @RequestMapping(value = "/editUser.html", method = RequestMethod.GET)
    public String showEditUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userDao.findUserById(id));
        return "WEB-INF/jsp/addEditUser.jsp";
    }

 /*   @RequestMapping(value = "/addUser.html", method = RequestMethod.POST)
    public String addStudent(User user,ModelMap model) {
        model.addAttribute("login", user.getLogin());
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("birthDate", user.getBirthDate());
        model.addAttribute("active", user.getActive());
        User newUser = new User(user.getLogin(),user.getName(),user.getEmail(),user.getBirthDate(),user.getActive());
        userDao.saveUser(newUser);
        return "WEB-INF/jsp/users.jsp";
    }*/
}