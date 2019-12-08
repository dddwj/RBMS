package com.ecust.utms.mapper;

import com.ecust.utms.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {

    // 查询某个课程的教参(根据课程代码)
    @Select("select a.*\n" +
            "from book a,course b\n" +
            "where a.CID=b.CID and a.CID=4")
    Book getBookByCID(Integer CID);


}
