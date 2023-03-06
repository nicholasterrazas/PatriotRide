package com.patriotride.webbackend.user;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


/**
 *  UserService Class:
 *  handles Firestore database functionalities for the "users" database
 *  "users" database is a collection of JSON documents
 *
 *  JSON body example:
 *
 *  {
 *      "id": "jdoe123",
 *      "email": "jdoe123@gmu.edu",
 *      "firstName": "john",
 *      "lastName": "doe",
 *      "zipCode": "22",
 *      "isDriver": true,
 *      "isRider": false,
 *      "rating": true,
 *      "isFavorite": false,
 *      "isBlocked": false
 *  }
 *
 *   UserController catches HTTP requests and uses the "users" database accordingly
 *
 *  TODO: Need to add list attributes for storing favorite users, blocked users, and posts
 *
 */
@Service
public class UserService {

    public String createUser(User user) throws ExecutionException, InterruptedException {
        // get instance of Firestore database
        Firestore dbFirestore = FirestoreClient.getFirestore();

        //from the firestore collections
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getId()).set(user);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUser(String netID) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(netID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        User user;
        if (document.exists()){
            user = document.toObject(User.class);
            return user;
        }
        return null;
    }

    public String updateUser(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getId()).set(user);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUser(String id){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(id).delete();
        return "Successfully deleted: " + id;
    }



}
