package com.example.friendsbook;

import java.util.ArrayList;

public class FriendsBook {
    private ArrayList<Friend> friends; // friends in the friends book

    // constructor of friends book
    public FriendsBook() {
        friends = new ArrayList<>();
    }

    // return all friends
    public ArrayList<Friend> getFriends() {
        return friends;
    }
}
