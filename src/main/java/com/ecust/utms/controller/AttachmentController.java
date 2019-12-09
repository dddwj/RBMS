package com.ecust.utms.controller;

import com.ecust.utms.mapper.AttachmentMapper;
import com.ecust.utms.model.Attachment;
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
@RequestMapping("/attachment")
public class AttachmentController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AttachmentMapper attachmentMapper;

    @GetMapping("SearchAttachment")
    public String searchAttachment(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                             @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Searching attachment for: " + CID);

        // 调用MAPPER
        List<Attachment> attachments = attachmentMapper.getAtByCID(CID);

        map.put("attachments", attachments);

        return "rbms/attachment";
    }

    @GetMapping("AddAttachment")
    public String addAttachment(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                                   @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Adding attachment for: " + CID);
        logger.trace("Searching attachment for: " + CID);

        // 调用MAPPER
        List<Attachment> attachments = attachmentMapper.getAtByCID(CID);

        map.put("attachments", attachments);

        return "rbms/addAttachment";
    }

}
