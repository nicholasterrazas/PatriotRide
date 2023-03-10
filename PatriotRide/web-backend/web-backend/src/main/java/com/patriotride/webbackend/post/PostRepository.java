package com.patriotride.webbackend.post;

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
 *  PostService Class:
 *  handles Firestore database functionalities for the "posts" database
 *  "posts" database is a collection of JSON documents
 *
 *  JSON body example:
 *
 *  {
 *      "post_id": "post",
 *      "message":"inputted message"
 *  }
 *
 * TODO: make method to return all posts in a list
 *
 */
@Repository
public class PostRepository {
    public String createPost(Post post) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("posts").document(post.getPost_id()).set(post);

        return "Created post, time=" +collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Post getPost(String post_id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("posts").document(post_id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Post post;
        if (document.exists()){
            post = document.toObject(Post.class);
            return post;
        }
        return null;
    }

    public String updatePost(Post post) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("posts").document(post.getPost_id()).set(post);

        return "Updated post, time=" + collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deletePost(String post_id){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("posts").document(post_id).delete();
        return "Successfully deleted: " + post_id;
    }

    public List<Post> getAllPosts() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference = dbFirestore.collection("posts").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<Post> postList = new ArrayList<>();
        Post post = null;

        while (iterator.hasNext()){
            DocumentReference currentDocRef = iterator.next();
            ApiFuture<DocumentSnapshot> future = currentDocRef.get();
            DocumentSnapshot document = future.get();

            post = document.toObject(Post.class);
            postList.add(post);

        }

        return postList;
    }
}
