package com.air.airtest.controller;

import com.air.airtest.config.Result;
import com.air.airtest.entity.Feedback;
import com.air.airtest.mapper.FeedbackMapper;
import com.air.airtest.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Resource
    FeedbackMapper feedbackMapper;

    @GetMapping("/selectfeedback")
    public Result<?> selectFeedback(@RequestParam(defaultValue = "") String servicerid) {
        Feedback as = feedbackService.getInfo(servicerid);
        return Result.success(as);
    }

    // 更新反馈表单(每次客户评价都要更新)
    @GetMapping("/updatefeedback")
    public Result< ? > updateFeedback(@RequestParam(defaultValue = "") String servicerid,
                                      @RequestParam(defaultValue = "") String customerid,
                                      @RequestParam(defaultValue = "") String Feedback_content,
                                      @RequestParam(defaultValue = "") String Feedback_date)
    {
        System.out.println("&&&&"+servicerid);
        System.out.println("&&&&"+customerid);
        System.out.println("&&&&"+Feedback_content);
        System.out.println("&&&&"+Feedback_date);
        int a = feedbackService.updateFeedbackInfo(servicerid,customerid,Feedback_content,Feedback_date);
        System.out.println(a);
        return Result.success(a);
    }

}
