package com.ecust.utms.controller;

import com.ecust.utms.model.Attachment;
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
@RequestMapping("/attachment")
public class AttachmentController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("SearchAttachment")
    public String searchAttachment(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching attachment for: " + CID);

        Attachment attachment1 = new Attachment();
        attachment1.setAID(999);
        attachment1.setATID(2);
        attachment1.setATName("软件工程导论PPT");
        attachment1.setATPath("userfiles/elective.xlsx");

        LinkedList<Attachment> attachments = new LinkedList<>();
        attachments.add(attachment1);

        map.put("attachments", attachments);

        return "rbms/attachment";
    }

}
