package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class MainController {
    @ResponseBody
    @GetMapping
    public String home(@RequestParam Optional<Integer>  userId ){
        return "user"+userId;
    }
}
