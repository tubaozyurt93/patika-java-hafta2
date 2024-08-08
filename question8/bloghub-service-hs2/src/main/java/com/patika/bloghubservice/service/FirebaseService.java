package com.patika.bloghubservice.service;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.patika.bloghubservice.model.Blog;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FirebaseService {

    private final BlogService blogService;

    // Blog’lar bir tane resime sahip olabilir, bu resim ücretsiz bir storage kaydedilmelidir.
    public Object upload(MultipartFile multipartFile,String title) {

        try {
            String fileName = multipartFile.getOriginalFilename();
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));
            File file = this.convertToFile(multipartFile, fileName);
            String TEMP_URL = this.uploadFile(file, fileName);
            file.delete();
            blogService.blogSetPhoto(fileName,title);
            return sendResponse("Successfully Uploaded !", TEMP_URL);
        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse("500", "Unsuccessfully Uploaded!");
        }

    }

    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("bloghub-bed02.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\emre3\\IdeaProjects\\bloghub-service-hs2\\src\\main\\java\\com\\patika\\bloghubservice\\firebase\\serviceAccountKey.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format("", URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
    private Object sendResponse(String s, String tempUrl) {
        return s;
    }
}