package com.air.airtest.controller;

import com.air.airtest.config.Result;
import com.air.airtest.entity.Guarantee_information;
import com.air.airtest.mapper.Guarantee_informationMapper;
import com.air.airtest.service.Guarantee_informationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/guarantee_information")
public class Guarantee_informationController {

    @Autowired
    Guarantee_informationService guarantee_informationService;

    @Resource
    Guarantee_informationMapper guaranteeInformationMapper;

    @GetMapping("/selectguarantee_information")
    public Result<?> selectGuarantee_information(@RequestParam(defaultValue = "")String guarantee_type) {
        Guarantee_information as = guarantee_informationService.getInfo(guarantee_type);
        return Result.success(as);
    }

    // 更新
    @GetMapping("/updateguarantee_information")
    public Result< ? >updateGuarantee_information(@RequestParam(defaultValue = "")String guarantee_type,
                                                  @RequestParam(defaultValue = "")String guarantee_information_content,
                                                  @RequestParam(defaultValue = "")String guarantee_information_costs)
    {
        System.out.println("&&&&" + guarantee_type);
        System.out.println("&&&&" + guarantee_information_content);
        System.out.println("&&&&" + guarantee_information_costs);
        int a = guarantee_informationService.updateGuarantee_informationInfo(guarantee_type, guarantee_information_content, guarantee_information_costs);
        System.out.println(a);
        return Result.success(a);
    }
}
