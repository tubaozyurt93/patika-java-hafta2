package com.patika.bloghubservice.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseConfig {
    @PostConstruct
    public void firebaseApp() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("C:\\Users\\emre3\\IdeaProjects\\bloghub-service-hs2\\src\\main\\java\\com\\patika\\bloghubservice\\firebase\\serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))

                .build();
        FirebaseApp.initializeApp(options);
    }
}