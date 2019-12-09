package com.ecust.utms.controller;

import com.ecust.utms.model.CourseWithTeacher;
import com.ecust.utms.model.Student;
import com.ecust.utms.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherPageController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/home")
    public String showStudentPage(Map<String, Object> map, HttpSession session, HttpServletRequest request) {
        return "rbms/teacher";
    }

    @GetMapping("SearchMyClass")
    public String searchByTeacher(Map<String, Object> map, HttpSession session, HttpServletRequest request) {
        Teacher user = (Teacher) session.getAttribute("loginuser");
        logger.trace("Teacher ID: " + user.getTID());

        CourseWithTeacher c1 = new CourseWithTeacher();
        c1.setTName("我本人");
        c1.setTerm("19年学期");
        c1.setCID(1);
        c1.setCName("1号课");
        LinkedList<CourseWithTeacher> courses = new LinkedList<>();
        courses.add(c1);

        map.put("courses", courses);

        return "rbms/teacher";
    }

    @GetMapping("StartClass")
    public String startClass(Map<String, Object> map, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "classname", required = false) String classname,
                             @RequestParam(value = "term", required = false) String term) {
        Teacher user = (Teacher) session.getAttribute("loginuser");
        logger.trace("Teacher ID: " + user.getTID());
        logger.trace("classname, term: " + classname + ", " + term);



        map.put("msg", "成功, 请刷新！");

        return "rbms/teacher";


    }

}
