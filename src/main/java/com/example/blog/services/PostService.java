package com.example.blog.services;


import com.example.blog.models.Post;
import com.example.blog.repositories.PostDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // Spring Bean
public class PostService {
    private PostDao postDao;

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    // note that we don't need separate insert and update methods.
    // the save method is smart enough to figure out which it needs to do
    // i.e. if the passed object already has an `id` property, update an
    // existing record, if it does not, insert a new record
    public void save(Post post) {
        postDao.save(post);
    }

    // we'll need to define the return type as `Iterable` as that is
    // what the CrudRepository defines. You can think of `Iterable` as
    // an even more generic list, it is still a collection of items
    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public Post findOne(long id) {
        return postDao.findOne(id);
    }

    public void delete(long id) {
        postDao.delete(id);
    }
}