package com.patriotride.webbackend.user;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *  UserRepository Class:
 *  handles Firestore database functionalities for the "users" database
 *  "users" database is a collection of JSON documents
 *
 *  JSON body example:
 *
 *  {
 *      "user_id": "jdoe123",
 *      "email": "jdoe123@gmu.edu",
 *      "firstName": "john",
 *      "lastName": "doe",
 *      "zipCode": "22030",
 *      "isDriver": true,
 *      "isRider": false,
 *      "rating": true,
 *      "isFavorite": false,
 *      "isBlocked": false
 *  }
 *
 *
 *  TODO: Need to add list attributes for storing favorite users, blocked users, and posts, and method to return list of ALL users
 *
 */
@Repository
public class UserRepository {

    public String createUser(User user) throws ExecutionException, InterruptedException {
        // get instance of Firestore database
        Firestore dbFirestore = FirestoreClient.getFirestore();

        // from the Firestore collections
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getUser_id()).set(user);

        return "Created user, time=" + collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUser(String user_id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(user_id);
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
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getUser_id()).set(user);

        return "Updated user, time=" + collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUser(String user_id){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(user_id).delete();
        return "Successfully deleted: " + user_id;
    }

    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference = dbFirestore.collection("users").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<User> userList = new ArrayList<>();
        User user = null;

        while (iterator.hasNext()){
            DocumentReference currentDocRef = iterator.next();
            ApiFuture<DocumentSnapshot> future = currentDocRef.get();
            DocumentSnapshot document = future.get();

            user = document.toObject(User.class);
            userList.add(user);

        }

        return userList;
    }

}
