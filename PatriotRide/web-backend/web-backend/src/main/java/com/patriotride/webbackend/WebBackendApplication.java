package com.patriotride.webbackend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class WebBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBackendApplication.class, args);
		try {
			initializeFirebase();
			System.out.println("Firebase Successfully Initialized");
		} catch (Exception e) {
			System.out.println("Firebase Failed to Initialize");
		}
	}

	public static void initializeFirebase() throws IOException {
		Resource resource = new ClassPathResource("serviceAccountKey.json");
		FileInputStream serviceAccount = new FileInputStream(resource.getFile());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);
	}

}
