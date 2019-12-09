package com.ecust.utms;

import com.ecust.utms.mapper.*;
import com.ecust.utms.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtmsApplicationTests {

    @Autowired
    AttachmentMapper attachmentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ThesisMapper thesisMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    BookMapper bookMapper;

    @Test
    public void contextLoads() {
//        List<CourseWithTeacher> CWTs = courseMapper.getCWTByName("英语");
//        for(CourseWithTeacher cwt:CWTs)
//            System.out.println(cwt.toString());
//
//        CourseWithTeacher cwtid = courseMapper.getCWTByCID(2);
//        System.out.println(cwtid.toString());
//
//        List<CourseWithTeacher> CWT1s = courseMapper.getStudentCWT("10161870");
//        for(CourseWithTeacher cwt:CWT1s)
//            System.out.println(cwt.toString());
//e
        List<CourseWithTeacher> CWT2s = courseMapper.getCWTByMajor("软件工程");
        for(CourseWithTeacher cwt:CWT2s)
            System.out.println(cwt.toString());

//        Book book = bookMapper.getBookByCID(1);
//        System.out.println(book.toString());
//
//        List<Attachment> as = attachmentMapper.getAtByCID(1);
//        for(Attachment a:as)
//            System.out.println(a.toString());
    }

}
