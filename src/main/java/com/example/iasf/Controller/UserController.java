package com.example.iasf.Controller;

import com.example.iasf.Entity.User;
import com.example.iasf.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController extends HttpServlet {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/user/create", method = RequestMethod.GET)
    public String getCreateUser(@ModelAttribute User u) {return "user-form";};

    @RequestMapping(path = "user/create", method = RequestMethod.POST)
    public String createUser(@Valid User u) {
        userRepository.save(u);
        return "redirect:/";
    }

    @RequestMapping(path = "user/list", method = RequestMethod.GET)
    public String userList(Model model) {
        List<User> userList = (List<User>) userRepository.findAll();
        model.addAttribute("userList", userList);
        return "user-list";
    }

    @RequestMapping(path = "/user/list/{name}", method = RequestMethod.GET)
    public String userList2(Model model, @PathVariable("name") String name) {
        model.addAttribute("userList", userRepository.findDistinctByName(name));
        return "user-list";
    }

    @RequestMapping(path = "/user/edit/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable int id, Model model) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            model.addAttribute("user", optionalUser.get());
            return "user-form";
        } else {
            return "not-found";
        }
    }

    @RequestMapping(path = "user/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return "redirect:/user/list";
        } else {
            return "not-found";
        }
    }

}
