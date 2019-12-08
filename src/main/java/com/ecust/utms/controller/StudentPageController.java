package com.ecust.utms.controller;

import com.ecust.utms.model.CourseWithTeacher;
import com.ecust.utms.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student/")
public class StudentPageController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("home")
    public String showStudentPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        return "rbms/student";
    }

    @GetMapping("SearchByMajor")
    public String searchByMajor(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                                @RequestParam(value = "major", required = false) String major){
        Student user = (Student)session.getAttribute("loginuser");
        logger.trace("Student ID: " + user.getSID());
        logger.trace("Searching Major: " + major);

        CourseWithTeacher course1 = new CourseWithTeacher();
        course1.setCID(1);
        course1.setCName(major);
        course1.setTerm("1");
        course1.setTName("TName");

        LinkedList<CourseWithTeacher> courses = new LinkedList<>();
        courses.add(course1);
        map.put("courses", courses);

        return "rbms/student";
    }

    @GetMapping("SearchByClassname")
    public String searchByClassname(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                                    @RequestParam(value = "classname", required = false) String classname){
        Student user = (Student)session.getAttribute("loginuser");
        logger.trace("Student ID: " + user.getSID());
        logger.trace("Searching Class: " + classname);

        CourseWithTeacher course1 = new CourseWithTeacher();
        course1.setCID(1);
        course1.setCName(classname);
        course1.setTerm("1");
        course1.setTName("TName");

        LinkedList<CourseWithTeacher> courses = new LinkedList<>();
        courses.add(course1);
        map.put("courses", courses);

        return "rbms/student";
    }

    @GetMapping("SearchMyClass")
    public String searchByClassname(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student user = (Student)session.getAttribute("loginuser");
        logger.trace("Student ID: " + user.getSID());
        logger.trace("Searching Student: " + user.getSID());

        CourseWithTeacher course1 = new CourseWithTeacher();
        course1.setCID(1);
        course1.setCName("学生: " + user.getSID());
        course1.setTerm("1");
        course1.setTName("TName");

        LinkedList<CourseWithTeacher> courses = new LinkedList<>();
        courses.add(course1);
        map.put("courses", courses);

        return "rbms/student";
    }

}
