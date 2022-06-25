package com.air.airtest.service.impl;

import com.air.airtest.entity.Feedback;
import com.air.airtest.mapper.FeedbackMapper;
import com.air.airtest.service.FeedbackService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class FeedbackSeviceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    @Override
    public Feedback getInfo(String servicerid) {
        return feedbackMapper.getInfo(servicerid);
    }

    @Override
    public int updateFeedbackInfo(String servicerid, String customerid, String Feedback_content, String Feedback_date) {
        return feedbackMapper.updateFeedbackInfo(servicerid, customerid, Feedback_content, Feedback_date);
    }

    @Override
    public int insert(Feedback entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(Feedback entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<Feedback> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(Feedback entity) {
        return 0;
    }

    @Override
    public int update(Feedback entity, Wrapper<Feedback> updateWrapper) {
        return 0;
    }

    @Override
    public Feedback selectById(Serializable id) {
        return null;
    }

    @Override
    public List<Feedback> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<Feedback> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper<Feedback> queryWrapper) {
        return null;
    }

    @Override
    public List<Feedback> selectList(Wrapper<Feedback> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<Feedback> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<Feedback> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Feedback>> P selectPage(P page, Wrapper<Feedback> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<Feedback> queryWrapper) {
        return null;
    }
}
