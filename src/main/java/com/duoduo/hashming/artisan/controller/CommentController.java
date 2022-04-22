package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.CommentDTO;
import com.duoduo.hashming.artisan.dto.ResultDTO;
import com.duoduo.hashming.artisan.entity.Comment;
import com.duoduo.hashming.artisan.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentController {

    /*@Autowired
    private CommentService commentService;*/

//response注解可以把对象自动的序列化成为json
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO, HttpServletRequest request) {//requestbody可以把json数据从前端传递给后端并且
        User user = (User)request.getSession().getAttribute("user");
        if (user==null){
            return ResultDTO.errorOf(2002,"没有进行登录，要先登录才行");
        }
        //把接收过来的数据存储在comment中
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
//        commentService.insert(comment);
        Map<Object,Object> objectObjectMap = new HashMap<>();
        objectObjectMap.put("message","成功");
        return objectObjectMap;
    }
}
