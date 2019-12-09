package com.ecust.utms.controller;

import com.ecust.utms.mapper.BookMapper;
import com.ecust.utms.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BookMapper bookMapper;

    @GetMapping("SearchBook")
    public String searchBook(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching Book for: " + CID);

        // 调用mapper
        Book book = bookMapper.getBookByCID(CID);
        map.put("book", book);

        return "rbms/book";
    }
}
