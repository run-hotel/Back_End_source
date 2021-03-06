package com.air.airtest.service.impl;

import com.air.airtest.entity.Comment;
import com.air.airtest.service.CommentService;
import com.air.airtest.utils.SensitiveFilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2021-12-29 19:37:30
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private com.air.airtest.mapper.CommentMapper CommentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Integer id) {
        return this.CommentMapper.queryById(id);
    }

    @Override
    public int update1(Integer id, String content) {
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
        sensitiveFilter.init();
        return this.CommentMapper.update1(id, sensitiveFilter.filter(content));
    }
    @Override
    public List<Comment> queryById1(Integer id) {
        return  CommentMapper.queryById1(id);
    }
   /* *//**
     * 分页查询
     *
     * @param comment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     *//*
    @Override
    public Page<Comment> queryByPage(Comment comment, PageRequest pageRequest) {
        long total = this.CommentMapper.count(comment);
        return new PageImpl<>(this.CommentMapper.queryAllByLimit(comment, pageRequest), pageRequest, total);
    }*/

    /**
     * 新增数据

     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
        sensitiveFilter.init();
        comment.setContent(sensitiveFilter.filter(comment.getContent()));
        this.CommentMapper.insert(comment);
        System.out.println(comment.getContent() + "-----------comment-------------"+ comment.getId());
        return comment;
    }
    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.CommentMapper.deleteById(id) > 0;
    }



    @Override
    public PageInfo<Comment> queryAllComment(Integer pageNum, Integer pageSize, String roomNumber) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> comments = CommentMapper.queryAll(roomNumber);
        PageInfo<Comment> commentPageInfo = new PageInfo<>(comments);
        return commentPageInfo;
    }

    @Override
    public List<Comment> queryAllComment(String roomNumber) {
        return  CommentMapper.queryAll(roomNumber);
    }
    @Override
    public List<Comment> queryAllComment1() {
        return CommentMapper.queryAll1();
    }
}
