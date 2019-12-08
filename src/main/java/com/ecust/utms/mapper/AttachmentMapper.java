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

    @Options(useGeneratedKeys = true,keyProperty = "ATID")
    @Insert("insert into attachment values (ATPath=#{ATPath},CID=#{CID}")
    int insertAt(Attachment attachment);

}
