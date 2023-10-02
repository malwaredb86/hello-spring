package com.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HelloController {

    @RequestMapping(path = "/hello", method = {RequestMethod.POST})
    public String helloPost(@RequestParam String name, @RequestParam String language, Model model) {
        String thegreeting = createMessage(name, language);
        model.addAttribute("greeting", thegreeting);
        return "hello";
    }


    public static String createMessage(String name, String language){
        String greeting = "";
        if (language.equals("English")){
            greeting = "Hello, " + name + "!";
        } else if (language.equals("French")){
            greeting = "Bonjour, " + name + "!";
        } else if (language.equals("Spanish")) {
            greeting = "Hola, " + name + "!";
        } else if (language.equals("Italian")) {
            greeting = "Ciao, " + name + "!";
        } else if (language.equals("Portuguese")) {
            greeting = "Oi, " + name + "!";
        }
        return greeting;
    }

    // Handles requests at path /hello
   // @GetMapping("hello")
   // @ResponseBody
    //public String hello() {
       // return "Hello, Spring!";
  // }

    @GetMapping({"form"})
    public String helloForm(){
        return "form";
    }


    public String goodbye() {
        return "Goodbye, Spring!";
    }
    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    //@ResponseBody
    //public String helloWithQueryParam(@RequestParam String name){
       // return "Hello, " + name + "!";
    //}

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        ArrayList<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
    //handle requests of the form http://localhost:8080/hello/LaunchCode



}
