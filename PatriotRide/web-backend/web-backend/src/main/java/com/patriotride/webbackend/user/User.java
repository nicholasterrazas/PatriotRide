package com.patriotride.webbackend.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    // identifier
    private String netID;

    // contact
    private String email;
    private String firstName;
    private String lastName;
    private int zipCode;

    // roles
    private boolean isDriver;
    private boolean isRider;

    // reputation
    private double rating;
    private boolean isFavorite;
    private boolean isBlocked;

    // lists
//    private ArrayList<User> favoriteUsers;
//    private ArrayList<User> blockedUsers;
//    private ArrayList<Post> posts;



}
