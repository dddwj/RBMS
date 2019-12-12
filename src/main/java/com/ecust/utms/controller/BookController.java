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
import java.util.LinkedList;
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
        logger.trace("Searching Book for Class: " + CID);
        List<Book> mybooks = bookMapper.getBooksByCID(CID);
        map.put("mybooks", mybooks);

        map.put("CID", CID);

        return "rbms/book";
    }

    @GetMapping("AddBook")
    public String addBook(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching Book for Class: " + CID);
        List<Book> mybooks = bookMapper.getBooksByCID(CID);
        map.put("mybooks", mybooks);

        map.put("CID", CID);

        return "rbms/addBook";
    }

    @GetMapping("findByISBN")
    public String findByISBN(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                          @RequestParam(value = "ISBN", required = true) String ISBN,
                          @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching Book for Class: " + CID);
        List<Book> mybooks = bookMapper.getBooksByCID(CID);
        map.put("mybooks", mybooks);


        logger.trace("Searching Book of ISBN == " + ISBN);

        // 调用mapper
        Book book = bookMapper.getBookByISBN(ISBN);
        List<Book> books = new LinkedList<>();
        books.add(book);
        map.put("books", books);

        map.put("CID", CID);

        return "rbms/addBook";
    }

    @GetMapping("findByAuthor")
    public String findByAuthor(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "author", required = true) String author,
                             @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching Book for Class: " + CID);
        List<Book> mybooks = bookMapper.getBooksByCID(CID);
        map.put("mybooks", mybooks);


        logger.trace("Searching Book of Author == " + author);

        // 调用mapper
        List<Book> books = bookMapper.getBookByAuthor(author);
        map.put("books", books);

        map.put("CID", CID);

        return "rbms/addBook";
    }

    @GetMapping("findByName")
    public String findByName(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                               @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching Book for Class: " + CID);
        List<Book> mybooks = bookMapper.getBooksByCID(CID);
        map.put("mybooks", mybooks);


        logger.trace("Searching Book of Name == " + name);

        // 调用mapper
        List<Book> books = bookMapper.getBookByName(name);
        map.put("books", books);

        map.put("CID", CID);

        return "rbms/addBook";
    }

    @GetMapping("recommendBook")
    public String recommendBook(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                                @RequestParam(value = "Name", required = true) String name,
                                @RequestParam(value = "Publisher", required = true) String publisher,
                                @RequestParam(value = "Author", required = true) String author,
                                @RequestParam(value = "PublishingDate", required = true) String publishingDate,
                                @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching Book for Class: " + CID);
        List<Book> mybooks = bookMapper.getBooksByCID(CID);
        map.put("mybooks", mybooks);


        logger.trace("Recommending Book: " + name,  publisher, author, publishingDate);


        map.put("CID", CID);
        map.put("msg_rec", "推荐成功！");

        return "rbms/addBook";
    }

    @GetMapping("AddThisBook")
    public String addThisBook(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                                @RequestParam(value = "CID", required = true) Integer CID,
                                @RequestParam(value = "bookID", required = true) String ISBN){
        logger.trace("Searching Book for Class: " + CID);

        logger.trace("adding book " + ISBN + " to Class " + CID);

        // 调用mapper更新此本书的CID
        Boolean res = bookMapper.addExistedBook(CID,ISBN);

        map.put("CID", CID);

        if(res)
            map.put("msg_rec", "选择成功！");
        else
            map.put("msg_rec", "选择失败！");

        List<Book> mybooks = bookMapper.getBooksByCID(CID);
        map.put("mybooks", mybooks);

        return "rbms/addBook";
    }
}
