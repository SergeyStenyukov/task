package ofd.platforma.task.controller;

import ofd.platforma.task.config.Constants;
import ofd.platforma.task.domain.Balance;
import ofd.platforma.task.domain.User;
import ofd.platforma.task.domain.enums.BalanceType;
import ofd.platforma.task.exceptions.UserExistsException;
import ofd.platforma.task.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUser(Model model, Authentication authentication) {
        model.addAttribute(Constants.Attributes.USER, userService.findByLogin(authentication.getName()));
        model.addAttribute(Constants.Attributes.TYPES, BalanceType.values());
        model.addAttribute(Constants.Attributes.BALANCE, new Balance());
        return Constants.Attributes.USER;
    }

    @GetMapping("/")
    public String login() {
        return Constants.Templates.LOGIN;
    }

    @GetMapping("/register")
    public String showRegisterUserForm(Model model) {
        model.addAttribute(Constants.Attributes.USER, new User());
        return Constants.Templates.REGISTER;
    }

    @PostMapping("/register")
    public String processRegisterUser(@ModelAttribute User user, Model model) {
        try {
            encodePassword(user);
            userService.save(user);
            return Constants.Templates.LOGIN;
        } catch (UserExistsException e) {
            model.addAttribute(Constants.Attributes.ERRORS, e.getMessage());
            return Constants.Templates.REGISTER;
        }
    }

    @GetMapping(value = "/error")
    public String error() {
        return Constants.Templates.ERROR;
    }

    @PostMapping(value = "/user")
    public String addBalance(@ModelAttribute Balance balance, Authentication authentication, Model model) {
        try {
            userService.saveBalance(authentication.getName(), balance);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute(Constants.Attributes.ERRORS, Constants.Messages.INVALID_AMOUNT_FIELD_VALUE);
            return Constants.Attributes.USER;
        }
        return "redirect:/" + Constants.Attributes.USER;
    }

    private void encodePassword(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode(user.getPassword());
        user.setPassword(encoded);
    }
}
