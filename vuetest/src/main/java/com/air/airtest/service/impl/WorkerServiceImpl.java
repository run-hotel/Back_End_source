package com.air.airtest.service.impl;

import com.air.airtest.entity.Worker;
import com.air.airtest.mapper.DepartmentInfoMapper;
import com.air.airtest.mapper.WorkerMapper;
import com.air.airtest.service.WorkerService;
import com.air.airtest.utils.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
     WorkerMapper workerMapper;

    @Autowired
     DepartmentInfoMapper departmentInfoMapper;

    @Override
    public int insert(Worker worker) {
        if(workerMapper != null) {
            System.out.println("123");
        }
        worker.setPassword(MD5Utils.MD5Encode(worker.getPassword()));
        return workerMapper.insert(worker);
    }

    @Override
    public int delete(int workerId) {
        return workerMapper.deleteByPrimaryKey(workerId);
    }

    @Override
    public int updateById(Worker worker) {
        return workerMapper.updateByPrimaryKeySelective(worker);
    }

    @Override
    public Worker selectById(int workerId) {
        return workerMapper.selectByPrimaryKey(workerId);
    }

    @Override
    public Worker selectByUsername(String username) {
        return workerMapper.selectByUsername(username);
    }

    @Override
    public List<Worker> findAll() {
        List<Worker> workers = workerMapper.selectAll(null, null);
        for (Worker worker : workers) {
            worker.setDeptName(departmentInfoMapper.queryById(worker.getDepartment()).getDepartment());
        }
        return workers;
    }

    @Override
    public List<Worker> selectByRole(String role) {
        return workerMapper.selectByRole(role);
    }

    @Override
    public Worker login(String username, String password, String role) {
        String pass = MD5Utils.MD5Encode(password);
        return workerMapper.selectByUsernameAndPassword(username, pass, role);
    }

    @Override
    public Worker login(String username, String password) {
        String pass = MD5Utils.MD5Encode(password);
        return workerMapper.selectByUsernamePassword(username, pass);
    }

    @Override
    public PageInfo<Worker> AllOperatorByPage(Integer pageNum, Integer pageSize, String role, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Worker> rooms = workerMapper.selectAll(role, search);
        PageInfo<Worker> roomPageInfo = new PageInfo<>(rooms);
        List<Worker> list = roomPageInfo.getList();
        for (Worker workerVo : list) {
            workerVo.setDeptName(departmentInfoMapper.queryById(workerVo.getDepartment()).getDepartment());
        }


        return roomPageInfo;
    }

    @Override
    public int deleteBatchIds(List<Integer> ids) {
        return workerMapper.deleteBatch(ids);
    }

    @Override
    @Transactional
    public boolean insertBatchWorker(List<Worker> list) {
       return workerMapper.insertBatch(list);
    }

    @Override
    public Object findAll(String search) {
        List<Worker> workers = workerMapper.selectAll("operator", search);
        return workers;
    }


}
