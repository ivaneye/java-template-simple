package com.webapp.controller;

import com.mybatis.model.Post;
import com.webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ivan on 15-1-15.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value="/new",method= RequestMethod.POST)
    public String _new(Post post){
            postService.save(post);
        return "redirect:/article/show/" + post.getArtId() ;
    }

}
