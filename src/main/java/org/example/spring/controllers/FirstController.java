package org.example.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

@Controller
@RequestMapping("/first")
public class FirstController {


    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {

        // System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }


    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "first", required = false) int first,
                             @RequestParam(value = "second", required = false) int second,
                             @RequestParam(value = "mark", required = false) String mark, Model model) {
        double result;
        switch (mark) {
            case "multiplication":
                result = first * second;
                break;
            case "division":
                result = first / (double) second;
                break;
            case "subtraction":
                result = first - second;
                break;
            case "addition":
                result = first + second;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result", result);
        return "first/calculator";
    }
}
