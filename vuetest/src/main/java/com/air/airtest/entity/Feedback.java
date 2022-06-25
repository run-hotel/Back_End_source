package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("feedback")
@Data
public class Feedback {
    private String servicerid; // 客服工号
    private String customerid; // 客户账号
    private String Feedback_content; // 反馈的内容
    private String Feedback_date; // 反馈的时间
}
