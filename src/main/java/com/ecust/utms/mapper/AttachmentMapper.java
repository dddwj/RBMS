package com.ecust.utms.mapper;

import com.ecust.utms.model.Attachment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttachmentMapper {

    @Select("select * from attachment")
    List<Attachment> getAllAt();
    // 查询某个课程教参的其他资料
    @Select("select * from attachment where CID=#{CID}")
    List<Attachment> getAtByCID(Integer CID);

    @Select("select * from attachment where ATID=#{ATID}")
    Attachment getAtByATID(Integer ATID);

//    @Options(useGeneratedKeys = true,keyProperty = "ATID")
    @Insert("insert into attachment(ATName, ATPath, CID) values (#{ATName}, #{ATPath}, #{CID})")
    int insertAt(@Param("ATName") String ATName, @Param("ATPath") String ATPath, @Param("CID") Integer CID);

}
