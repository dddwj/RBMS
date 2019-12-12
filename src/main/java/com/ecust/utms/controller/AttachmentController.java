package com.ecust.utms.controller;

import com.ecust.utms.mapper.AttachmentMapper;
import com.ecust.utms.model.Attachment;
import com.ecust.utms.model.Student;
import com.ecust.utms.model.Teacher;
import com.ecust.utms.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    FileService fileService;

    @Autowired
    AttachmentMapper attachmentMapper;

//    @GetMapping("SearchAttachment")
//    public String searchAttachment(Map<String,Object> map, HttpSession session, HttpServletRequest request,
//                             @RequestParam(value = "CID", required = true) Integer CID){
//        logger.trace("Searching attachment for: " + CID);
//
//        // 调用MAPPER
//        List<Attachment> attachments = attachmentMapper.getAtByCID(CID);
//
//        map.put("attachments", attachments);
//
//        return "rbms/attachment";
//    }

    @GetMapping("AddAttachment")
    public String addAttachment(Map<String,Object> map, HttpSession session, HttpServletRequest request,
                                   @RequestParam(value = "CID", required = true) Integer CID){
        logger.trace("Adding attachment for: " + CID);
        logger.trace("Searching attachment for: " + CID);

        // 调用MAPPER
        List<Attachment> attachments = attachmentMapper.getAtByCID(CID);

        map.put("attachments", attachments);
        map.put("CID", CID);

        return "rbms/addAttachment";
    }

    @PostMapping(value = "/upload")
    public String uploadStuFile(@RequestParam("file") MultipartFile file,
                                @RequestParam("CID") Integer CID,
                                Map<String,Object> map, HttpSession session,
                                HttpServletResponse response) {
        Teacher teacher = (Teacher)session.getAttribute("loginuser");
        String tid = teacher.getTID();
        logger.trace("--->Teacher: " + tid + ", now uploading...");

        String status = fileService.uploadFile(file);
        if("上传成功".equals(status)){
            map.put("status", "ok");
            // 更新数据库
            attachmentMapper.insertAt(file.getOriginalFilename(), file.getOriginalFilename(), CID);
        }

        return "redirect:/attachment/AddAttachment?CID=" + CID;
    }

}
