package com.patriotride.webbackend.user;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class User {

    // user identifier
    private String user_id;

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
    // private List<User> favoriteUsers;
    // private List<User> blockedUsers;
    // private List<Post> posts;



}
