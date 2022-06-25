package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("guarantee_information")
@Data
public class Guarantee_information {
    private String guarantee_type; // 收费的类型
    private String guarantee_information_content; // 收费的内容
    private String guarantee_information_costs; // 费用
}
