package com.air.airtest.controller.common;

import com.air.airtest.response.AjaxResult;
import com.air.airtest.response.ResponseTool;
import com.air.airtest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public AjaxResult getAllHotel(){

        return ResponseTool.success(hotelService.selectAll());
    }
}
