package com.ecust.utms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherPageController {
    @GetMapping("/home")
    public String showStudentPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        return "rbms/teacher";
    }
}
