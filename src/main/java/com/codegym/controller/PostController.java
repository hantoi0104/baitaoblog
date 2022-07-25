package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.services.PostService;
import com.codegym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class PostController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @GetMapping("/home")
    public ModelAndView home(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts" , postService.findAll(PageRequest.of(page, 5, Sort.by("date"))));
        return modelAndView;
    }

    @GetMapping("/create/post")
    public ModelAndView ShowCreat(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @PostMapping("/create/post")
    public ModelAndView create(@ModelAttribute ("post") Post post, @RequestParam MultipartFile file){
        String nameImg = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File("D:\\Module4\\6.JPA\\blog\\src\\main\\webapp\\WEB-INF\\img\\post\\" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
      post.setImg("/img/post/"+nameImg);
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

}
