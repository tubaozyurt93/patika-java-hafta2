package com.patika.bloghubservice.service;

import com.patika.bloghubservice.converter.BlogConverter;
import com.patika.bloghubservice.dto.request.BlogSaveRequest;
import com.patika.bloghubservice.dto.response.BlogResponse;
import com.patika.bloghubservice.model.Blog;
import com.patika.bloghubservice.model.BlogComment;
import com.patika.bloghubservice.model.User;
import com.patika.bloghubservice.model.enums.BlogStatus;
import com.patika.bloghubservice.model.enums.StatusType;
import com.patika.bloghubservice.repository.BlogRepository;
import com.patika.bloghubservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogResponse createBlog(String email, BlogSaveRequest request) {

        //ödev: kullanıcı blog yayınlamak için approved bir statuye sahip olmalı

        // Kullanıcıyı e-posta adresine göre bul
        Optional<User> foundUser = userRepository.findByEmail(email);

        // Kullanıcının onaylanmış olduğundan emin ol
        if (foundUser.isEmpty() || !foundUser.get().getStatusType().equals(StatusType.APPROVED)) {
            throw new IllegalStateException("Blog yayınlamak için onaylanmış bir kullanıcı olmalısınız.");
        }

        // Blog oluştur ve kullanıcıyla ilişkilendir
        Blog blog = new Blog(request.getTitle(), request.getText(), foundUser.get());

        // Blog'u kullanıcıya ekle
        List<Blog> blogList = new ArrayList<>(foundUser.get().getBlogList());
        blogList.add(blog);
        foundUser.get().setBlogList(blogList);

        // Blog'u veritabanına kaydet
        blogRepository.save(blog);

        return BlogConverter.toResponse(blog);
    }

    public Blog getBlogByTitle(String title) {
        return blogRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("blog bulunamadı"));
    }

    public void addComment(String title, String email, String comment) {

        Blog foundBlog = getBlogByTitle(title);

        Optional<User> user = userRepository.findByEmail(email);

        BlogComment blogComment = new BlogComment(user.get(), comment);

        foundBlog.getBlogCommentList().add(blogComment);

        blogRepository.addComment(title, foundBlog);

    }

    public List<Blog> getBlogsFilterByStatus(BlogStatus blogStatus, String email) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        return foundUser.get().getBlogList().stream()
                .filter(blog -> blogStatus.equals(blog.getBlogStatus()))
                .toList();
    }

    public void changeBlogStatus(BlogStatus blogStatus, String title) {

        Blog foundBlog = getBlogByTitle(title);

        if (foundBlog.getBlogStatus().equals(BlogStatus.PUBLISHED)) {
            throw new RuntimeException("statüsü PUBLISHED olan bir blog silinemez.");
        }

        foundBlog.setBlogStatus(blogStatus);

    }

    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    // like-count endpoint’ini bir kullanıcın en fazla 50 kere beğenibileceği şekilde refactor edin.
    public void likeBlog(String title, String email) {
        Blog blog = getBlogByTitle(title);
        if (blog.getLikedUsers().size() >= 50 && !blog.getLikedUsers().contains(email)) {
            throw new RuntimeException("Bir blogu en fazla 50 kez beğenebilirsiniz.");
        }

        if (blog.getLikedUsers().contains(email)) {
            throw new RuntimeException("Bu blogu zaten beğendiniz.");
        }

        blog.getLikedUsers().add(email);
        blog.setLikeCount(blog.getLikeCount() + 1);

        blogRepository.likeBlog(title, blog);
    }

    public Long getLikeCountByTitle(String title) {

        Blog blog = getBlogByTitle(title);

        return blog.getLikeCount();
    }

    public List<Blog> getPublishedAndDraftBlogs(String email) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        if (foundUser.isEmpty()) {
            throw new RuntimeException();
        } else if (blogRepository.findAll().size() == 0) {
            throw new RuntimeException();
        } else {
            return blogRepository.findAll().stream()
                    .filter(blog -> blog.getUser().getEmail().equals(foundUser.get().getEmail()))
                    .filter(blog -> blog.getBlogStatus().equals(BlogStatus.PUBLISHED) || blog.getBlogStatus().equals(BlogStatus.DRAFT))
                    .collect(Collectors.toList());
        }
    }

    //Kullanıcı kendi blog’larından DRAFT statüsünde olanları hard delete ile silebilir.
    public List<Blog> hardDelete(String email) {


        Optional<User> foundUser = userRepository.findByEmail(email);

        if (foundUser.isEmpty()) {
            throw new RuntimeException();
        } else if (foundUser.get().getBlogList().isEmpty()) {
            throw new RuntimeException();
        }
        blogRepository.hardDelete(foundUser);

        return blogRepository.findAll();

    }

    public void blogSetPhoto(String photoUrl,String title){
        blogRepository.blogSetPhoto(photoUrl,title);
    }
}

