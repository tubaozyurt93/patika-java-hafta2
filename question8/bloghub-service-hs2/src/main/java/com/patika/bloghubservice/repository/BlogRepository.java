package com.patika.bloghubservice.repository;


import com.patika.bloghubservice.model.Blog;
import com.patika.bloghubservice.model.User;
import com.patika.bloghubservice.model.enums.BlogStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BlogRepository {

    private Map<String, Blog> blogMap = new HashMap<>();

    public void save(Blog blog) {
        blogMap.put(blog.getTitle(), blog);
    }

    public Optional<Blog> findByTitle(String title) {
        return blogMap.values()
                .stream()
                .filter(blog -> blog.getTitle().equals(title))
                .filter(blog -> !blog.getBlogStatus().equals(BlogStatus.DELETED))
                .findFirst();
    }

    public List<Blog> findAll() {
        return blogMap.values().stream().toList();
    }

    public void addComment(String title, Blog blog) {
        blogMap.remove(title);
        blogMap.put(title, blog);
    }

    public void likeBlog(String title, Blog blog) {
        blogMap.remove(title);
        blogMap.put(title, blog);
    }
    public void hardDelete(Optional<User> optionalUser) {
        optionalUser
                .map(User::getEmail)
                .ifPresent(email ->
                        blogMap.values().removeIf(blog ->
                                blog.getUser().getEmail().equalsIgnoreCase(email) &&
                                        blog.getBlogStatus().equals(BlogStatus.DRAFT)
                        )
                );
    }

    public void blogSetPhoto(String photoUrl,String title){
        Blog blog = blogMap.get(title);
        blog.setFotoUrl(photoUrl);
        blogMap.remove(title);
        blogMap.put(title,blog);
    }
}
