package com.ecust.utms.mapper;

import com.ecust.utms.model.CourseWithTeacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {

    // 查询某个学生所有的课程（SID）
    @Select("select a.CID as 'CID',a.`Name` as 'CName',a.Term as 'Term',d.`Name` as 'TName'\n" +
            "from course a,student b,selectcourse c,teacher d\n" +
            "where a.CID=c.CID and b.SID=c.SID and a.TID=d.TID\n" +
            "and b.SID=#{SID}\n")
    List<CourseWithTeacher> getStudentCWT(String SID);

    // 查询某个老师的所有课程（TID）
    @Select("select a.CID as 'CID',a.`Name` as 'CName',a.Term as 'Term',b.`Name` as 'TName'\n" +
            "from course a,teacher b\n" +
            "where a.TID=b.TID and b.TID=#{TID}")
    List<CourseWithTeacher> getTeacherCWT(String TID);

    // 查询课程（课程名模糊匹配 搜英语）
    @Select("select a.CID as 'CID',a.`Name` as 'CName',a.Term as 'Term',b.`Name` as 'TName'\n" +
            "        from course a,teacher b\n" +
            "        where a.TID=b.TID and a.`Name` like '%${value}%'")
    List<CourseWithTeacher> getCWTByName(String keyword);

    // 查询课程（课程代码 搜1）
    @Select("select a.CID as 'CID',a.`Name` as 'CName',a.Term as 'Term',b.`Name` as 'TName'\n" +
            "from course a,teacher b\n" +
            "where a.TID=b.TID and a.CID=#{CID}")
    CourseWithTeacher getCWTByCID(Integer CID);

    // 查询专业课程（专业名）
    @Select("select distinct a.CID as 'CID',a.`Name` as 'CName',a.Term as 'Term',d.`Name` as 'TName'\n" +
            "from course a,selectcourse b,student c,teacher d\n" +
            "where a.CID = b.CID and b.SID = c.SID and a.TID = d.TID\n" +
            "and c.Major = #{major}")
    List<CourseWithTeacher> getCWTByMajor(String major);

    // 教师开课
    @Insert("insert into course(`Name`,Term,TID)\n" +
            "values(#{Name},#{Term},#{TID})")
    Boolean newCourse(String Name,String Term,String TID);
}
