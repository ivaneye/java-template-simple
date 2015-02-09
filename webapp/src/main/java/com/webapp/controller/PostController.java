package com.webapp.controller;

import com.webapp.domain.PostDomain;
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
    public String _new(PostDomain domain){
            postService.save(domain);
        return "redirect:/article/show/" + domain.getArtId() ;
    }

}
