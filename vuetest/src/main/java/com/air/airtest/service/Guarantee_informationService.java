package com.air.airtest.service;

import com.air.airtest.entity.Guarantee_information;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface Guarantee_informationService extends BaseMapper<Guarantee_information> {
    Guarantee_information getInfo(@Param("guarantee_type")String guarantee_type);
    int updateGuarantee_informationInfo(@Param("guarantee_type")String guarantee_type,
                                        @Param("guarantee_information_content")String guarantee_information_content,
                                        @Param("guarantee_information_costs")String guarantee_information_costs);
}