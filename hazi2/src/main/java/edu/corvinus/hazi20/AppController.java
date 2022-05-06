package edu.corvinus.hazi20;

import edu.corvinus.hazi20.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @PostMapping ("/login")
    public String tryToLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        final Optional<User> foundUser = userRepo.findByUsername(username);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        final User user = foundUser.get();
        String alreadyinuse = user.getPassword();

        boolean b = passwordEncoder.matches(password, alreadyinuse);


        if (foundUser.isEmpty() || !b) {
            return "index";
        }
            return "success";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/process_register")
    public String RegistrationAfterCheckUserInfo(@Valid User user,
                                  BindingResult bindingResult) {

        final Optional<User> foundUser = userRepo.findByUsername(user.getUsername());

        if (!foundUser.isEmpty()) {
            bindingResult.rejectValue("username", "error.user", "Már regisztráltak ezzel a felhasználónévvel!");
        }

        if (bindingResult.hasErrors()) {
            return "signup";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "success";

        }

    }
