package com.techgem.blogger.controller;

import com.techgem.blogger.model.Blog;
import com.techgem.blogger.repository.BloggerRepository;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/blog")
@RestController
@Api(value="BloggerController")
public class BloggerController {

    Logger logger = LoggerFactory.getLogger(BloggerController.class);

    @Autowired
    BloggerRepository bloggerRepository;

    @GetMapping(path = "/getAll")
    public List<Blog> getAllBlog() {
        logger.info("Entering getAllBlog method");
        return bloggerRepository.getAllBlogs();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Blog addBlog(@RequestBody Blog blog) {
        logger.info("Entering addBlog method");
        bloggerRepository.addBlog(blog);
        return blog;
    }

    @PostMapping(path = "/delete", consumes = "application/json")
    public void deleteBlog(@RequestBody Blog blog) {
        logger.info("Entering deleteBlog method");
        bloggerRepository.deleteBlog(blog);
    }

}
