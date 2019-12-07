package com.ecust.utms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("SearchBook")
    public String searchBook(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching Book for: " + CID);



        return "rbms/book";
    }
}
