package com.ecust.utms.controller;

import com.ecust.utms.mapper.CourseMapper;
import com.ecust.utms.model.CourseWithTeacher;
import com.ecust.utms.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CourseMapper courseMapper;

    @GetMapping("home")
    public String showStudentPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        return "rbms/student";
    }

    // 根据专业名搜索相关课程
    @GetMapping("SearchByMajor")
    public String searchByMajor(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                                @RequestParam(value = "major", required = false) String major){
        Student user = (Student)session.getAttribute("loginuser");
        logger.trace("Student ID: " + user.getSID());
        logger.trace("Searching Major: " + major);

        // 调用mapper
        List<CourseWithTeacher> courses = courseMapper.getCWTByMajor(major);

        map.put("courses", courses);

        return "rbms/student";
    }

    // 根据课程名搜索相关课程
    @GetMapping("SearchByClassname")
    public String searchByClassname(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                                    @RequestParam(value = "classname", required = false) String classname){
        Student user = (Student)session.getAttribute("loginuser");
        logger.trace("Student ID: " + user.getSID());
        logger.trace("Searching Class: " + classname);

        // 调用mapper
        List<CourseWithTeacher> courses = courseMapper.getCWTByName(classname);

        map.put("courses", courses);

        return "rbms/student";
    }

    @GetMapping("SearchMyClass")
    public String searchByClassname(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student user = (Student)session.getAttribute("loginuser");
        logger.trace("Student ID: " + user.getSID());
        logger.trace("Searching Student: " + user.getSID());

        // 调用mapper
        List<CourseWithTeacher> courses = courseMapper.getStudentCWT(user.getSID());

        map.put("courses", courses);

        return "rbms/student";
    }

}
