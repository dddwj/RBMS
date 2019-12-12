package com.ecust.utms.controller;

import com.ecust.utms.mapper.CourseMapper;
import com.ecust.utms.model.CourseWithTeacher;
import com.ecust.utms.model.Student;
import com.ecust.utms.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherPageController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CourseMapper courseMapper;

    @GetMapping("/home")
    public String showStudentPage(Map<String, Object> map, HttpSession session, HttpServletRequest request) {
        return "rbms/teacher";
    }

    @GetMapping("SearchMyClass")
    public String searchByTeacher(Map<String, Object> map, HttpSession session, HttpServletRequest request) {
        Teacher user = (Teacher) session.getAttribute("loginuser");
        logger.trace("Teacher ID: " + user.getTID());

        // 调用mapper
        List<CourseWithTeacher> courses = courseMapper.getTeacherCWT(user.getTID());

        map.put("courses", courses);

        return "rbms/teacher";
    }

    @GetMapping("StartClass")
    public String startClass(Map<String, Object> map, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "classname", required = false) String classname,
                             @RequestParam(value = "term", required = false) String term,
                             @RequestParam(value = "desc", required = false) String desc) {
        Teacher user = (Teacher) session.getAttribute("loginuser");
        logger.trace("Teacher ID: " + user.getTID());
        logger.trace("classname, term: " + classname + ", " + term);

        // 调用mapper添加课程
        Boolean res = courseMapper.newCourse(classname,term,user.getTID());
        if(res)
            map.put("msg", "成功, 已刷新！");
        else
            map.put("msg", "失败，请重试！");

        // 调用mapper重新刷新
        List<CourseWithTeacher> courses = courseMapper.getTeacherCWT(user.getTID());
        map.put("courses", courses);

        return "rbms/teacher";


    }

}
