package com.duoduo.hashming.artisan.service.impl;

import com.duoduo.hashming.artisan.entity.Comment;
import com.duoduo.hashming.artisan.mapper.CommentMapper;
import com.duoduo.hashming.artisan.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
