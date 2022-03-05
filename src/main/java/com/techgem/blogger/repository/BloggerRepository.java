package com.techgem.blogger.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.techgem.blogger.model.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BloggerRepository {

    Logger logger = LoggerFactory.getLogger(BloggerRepository.class);

    @Resource(name = "dynamoDBMapper")
    DynamoDBMapper dbMapper;

    public List<Blog> getAllBlogs() {
        return dbMapper.scan(Blog.class, new DynamoDBScanExpression());
    }

    public void addBlog(Blog blog) {
        dbMapper.save(blog);
        logger.info("Blog Added : "+ blog.getId());
    }

    public void deleteBlog(Blog blog) {
        dbMapper.delete(blog);
        logger.info("Blog delete : "+ blog.getId());
    }

}
