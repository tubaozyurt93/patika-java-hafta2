package com.patika.bloghubservice.controller;

import com.patika.bloghubservice.dto.request.BlogSaveRequest;
import com.patika.bloghubservice.dto.response.BlogResponse;
import com.patika.bloghubservice.dto.response.GenericResponse;
import com.patika.bloghubservice.model.Blog;
import com.patika.bloghubservice.service.BlogService;
import com.patika.bloghubservice.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final FirebaseService firebaseService;
    private final BlogService blogService;

    @PostMapping("/users/{email}")
    public GenericResponse<BlogResponse> createBlog(@RequestBody BlogSaveRequest request, @PathVariable String email) {
        return GenericResponse.success(blogService.createBlog(email, request), HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<List<Blog>> getAllBlogs() {
        return GenericResponse.success(blogService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public Blog getBlogByEmail(@PathVariable String title) {
        return blogService.getBlogByTitle(title);
    }

    @PutMapping("/{title}/users/{email}")
    public void addComment(@PathVariable String title, @PathVariable String email, @RequestBody String comment) {
        blogService.addComment(title, email, comment);
    }

    @PutMapping("/{title}/users/{email}/like-count")
    public void likeBlog(@PathVariable String title, @PathVariable String email) {
        //bir kullanıcı sadece maksimum 50 kere beğenebilir
        blogService.likeBlog(title, email);
    }

    @GetMapping("/{title}/like-count")
    public Long getLikeCountByTitle(@PathVariable String title) {
        return blogService.getLikeCountByTitle(title);
    }
   //commentleri getiren end-point

    //kullanıcı sadece kendi blog'larını gören endpoint

    // resim yükleme

    //Kullanıcı kendi PUBLISHED ve DRAFT olan blog’larını getiren endpoint
    @GetMapping("/{email}/published-draft")
    public List<Blog> getPublishedAndDraftBlogs(@PathVariable String email) {

        return blogService.getPublishedAndDraftBlogs(email);
    }

    //Kullanıcı kendi blog’larından DRAFT statüsünde olanları hard delete ile silebilir.
    @DeleteMapping("/{email}/hardDelete")
    public List<Blog> hardDeleteBlogs(@PathVariable String email) {
        return blogService.hardDelete(email);
    }
    //Blog’lar bir tane resime sahip olabilir, bu resim ücretsiz bir storage kaydedilmelidir.
    @PostMapping("/pic/{title}")
    public Object upload(@RequestParam("file") MultipartFile multipartFile, @PathVariable String title) {
        return firebaseService.upload(multipartFile,title);
    }

}
