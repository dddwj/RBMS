package com.ecust.utms.mapper;

import com.ecust.utms.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    // 查询某个课程的教参(根据课程代码)
    @Select("select a.*\n" +
            "from book a,course b\n" +
            "where a.CID=b.CID and a.CID=#{CID}")
    Book getBookByCID(Integer CID);

    // 查询某个课程的教参(根据课程代码)
    @Select("select a.*\n" +
            "from book a,course b\n" +
            "where a.CID=b.CID and a.CID=#{CID}")
    List<Book> getBooksByCID(Integer CID);

    // 在数据库里搜索某个教参（ISBN）
    @Select("select * from book\n" +
            "where ISBN = #{ISBN}")
    Book getBookByISBN(String ISBN);

    // 在数据库里搜索某个教参（模糊匹配书名）
    @Select("select * from book\n" +
            "where lower(`Name`) like '%${value}%'")
    List<Book> getBookByName(String name);

    // 在数据库里搜索某个教参（模糊匹配作者）
    @Select("select * from book\n" +
            "where `Author` like '%${value}%'")
    List<Book> getBookByAuthor(String name);

    // 为某个课程添加数据里已有的教参
    @Update("update book\n" +
            "set CID = #{CID}\n" +
            "WHERE ISBN = #{ISBN}")
    Boolean addExistedBook(@Param("CID") Integer CID, @Param("ISBN") String ISBN);

    // 为某个课程添加数据库里没有的教参
    @Insert("insert into book(ISBN,`Name`,Publisher,Author,PublishingDate,CID)\n" +
            "values(#{ISBN},#{Name},#{Publisher},#{Author},#{PublishingDate},#{CID})")
    Boolean addNotExistedbook(Book book);
}
