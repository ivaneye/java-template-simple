package com.webapp.controller;

import com.mybatis.model.Article;
import com.mybatis.model.Post;
import com.webapp.service.ArticleService;
import com.webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String index(Model model,@Valid Article article,BindingResult result) {
        if(result.hasErrors()){
            System.out.println(result.getFieldError().getDefaultMessage());
            model.addAttribute("_err",result);
            return "/article/new";
        }
        return "/article/new";
//        User user = AppContext.getUser();
//        if (user.getType() == 0) {
//            return "/article/new";
//        } else {
//            model.addAttribute("_msg", "没有权限!");
//            return "/error";
//        }
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String _new(Model model, @Valid Article article,BindingResult result) {
        if(result.hasErrors()){
            System.out.println(result.getFieldError().getDefaultMessage());
            model.addAttribute("_err",result);
            return "/article/new";
        }
        articleService.save(article);
        return "redirect:/article/success";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Article> articles = articleService.list();
        model.addAttribute("articles", articles);
        return "/article/list";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable String id) {
        Article article = articleService.selectById(id);
        List<Post> posts = postService.selectByArtId(id);
        model.addAttribute("article", article);
        model.addAttribute("posts", posts);
        return "/article/show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String del(Model model, Long recId) {
        articleService.deleteById(recId);
        return "redirect:/article/list";
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public void del(Long recId) {
        System.out.println("recId = " + recId);
        articleService.deleteById(recId);
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String suc() {
        return "/article/suc";
    }
}