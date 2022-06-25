package com.air.airtest.service.impl;

import com.air.airtest.entity.Guarantee_information;
import com.air.airtest.mapper.Guarantee_informationMapper;
import com.air.airtest.service.Guarantee_informationService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class Guarantee_informationSeviceImpl implements Guarantee_informationService {

    @Autowired
    Guarantee_informationMapper guaranteeInformationMapper;
    @Override
    public Guarantee_information getInfo(String guarantee_type) {
        return guaranteeInformationMapper.getInfo(guarantee_type);
    }

    @Override
    public int updateGuarantee_informationInfo(String guarantee_type, String guarantee_information_content, String guarantee_information_costs) {
        return guaranteeInformationMapper.updateGuarantee_informationInfo(guarantee_type, guarantee_information_content, guarantee_information_costs);
    }

    @Override
    public int insert(Guarantee_information entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(Guarantee_information entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<Guarantee_information> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(Guarantee_information entity) {
        return 0;
    }

    @Override
    public int update(Guarantee_information entity, Wrapper<Guarantee_information> updateWrapper) {
        return 0;
    }

    @Override
    public Guarantee_information selectById(Serializable id) {
        return null;
    }

    @Override
    public List<Guarantee_information> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<Guarantee_information> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper<Guarantee_information> queryWrapper) {
        return null;
    }

    @Override
    public List<Guarantee_information> selectList(Wrapper<Guarantee_information> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<Guarantee_information> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<Guarantee_information> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Guarantee_information>> P selectPage(P page, Wrapper<Guarantee_information> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<Guarantee_information> queryWrapper) {
        return null;
    }
}
