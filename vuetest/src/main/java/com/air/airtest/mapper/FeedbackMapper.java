package com.air.airtest.mapper;

import com.air.airtest.entity.Feedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper extends BaseMapper<Feedback> {
    Feedback getInfo(@Param("servicerid")String servicerid);
    int updateFeedbackInfo(@Param("servicerid")String servicerid,
                           @Param("customerid")String customerid,
                           @Param("Feedback_content")String Feedback_content,
                           @Param("Feedback_date")String Feedback_date);
}
