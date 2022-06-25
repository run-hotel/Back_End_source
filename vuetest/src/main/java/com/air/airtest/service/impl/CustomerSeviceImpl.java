package com.air.airtest.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.air.airtest.entity.Customer;
import com.air.airtest.mapper.CustomerMapper;
import com.air.airtest.service.CustomerService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSeviceImpl implements CustomerService{

    @Autowired
    CustomerMapper customerMapper;
    @Override
    public Customer getInfo(String customerphone) {
        // TODO Auto-generated method stub
        return customerMapper.getInfo(customerphone);
    }

    @Override
    public int updateCustomerInfo(String customerphone, String customersex, String customerid, String customerage, String customerpassword) {
        // TODO Auto-generated method stub
        return customerMapper.updateCustomerInfo(customerphone, customersex, customerid, customerage, customerpassword);
    }

    @Override
    public int insert(Customer entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteById(Customer entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Wrapper<Customer> queryWrapper) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateById(Customer entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Customer entity, Wrapper<Customer> updateWrapper) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Customer selectById(Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> selectBatchIds(Collection<? extends Serializable> idList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> selectByMap(Map<String, Object> columnMap) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long selectCount(Wrapper<Customer> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> selectList(Wrapper<Customer> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<Customer> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<Customer> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <P extends IPage<Customer>> P selectPage(P page, Wrapper<Customer> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<Customer> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
