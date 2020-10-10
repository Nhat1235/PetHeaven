package com.vn.demo.service;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FireBaseService  {

	@PostConstruct
	public void initialize() throws IOException {
		try {
			FileInputStream serviceAccount = new FileInputStream(
					"./webtruyen-2436c-firebase-adminsdk-3bayq-3168ae730c.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://webtruyen-2436c.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public Firestore getFirebase() {
//		return FirestoreClient.getFirestore();
//	}
}
