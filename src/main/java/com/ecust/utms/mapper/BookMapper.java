package com.ecust.utms.mapper;

import com.ecust.utms.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    // 查询某个课程的教参(根据课程代码)
    @Select("select a.*\n" +
            "from book a,course b\n" +
            "where a.CID=b.CID and a.CID=4")
    Book getBookByCID(Integer CID);

    // 在数据库里搜索某个教参（ISBN）
    @Select("select * from book\n" +
            "where ISBN = #{ISBN}")
    Book getBookByISBN(String ISBN);

    // 在数据库里搜索某个教参（模糊匹配书名）
    @Select("select * from book\n" +
            "where Name like '%${name}%'")
    List<Book> getBookByName(String name);

}
