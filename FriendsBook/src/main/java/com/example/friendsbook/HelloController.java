package com.example.friendsbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    public TextField friendName;
    public TextField friendAddress;
    public TextField friendPhone;
    public Button btnAdd;
    public Button btnDelete;
    public Button btnDisplay;
    public FriendsBook book;
    public ListView friendsList;
    public TextArea infoText;

    public void initialize() {
        book = new FriendsBook();
    }
    public void onAddButtonClick(ActionEvent actionEvent) {
        // clear the infoText
        infoText.setText("");
        // get name, address and phone from the text fields
        String name = friendName.getText().trim();
        String address = friendAddress.getText().trim();
        String phone = friendPhone.getText().trim();
        // name, address and phone cannot be empty
        if(name.length()==0 || address.length()==0 || phone.length()==0) {
            infoText.setText("Error: Name, address and phone cannot be empty!");
        }
        // create a new friend
        else {
            Friend friend = new Friend(name, address, phone);
            book.getFriends().add(friend);
            // inform the addition
            infoText.setText("New friend " + name + " added to the Friends Book!");
        }
    }

    public void onDeleteButtonClick(ActionEvent actionEvent) {
        // clear the infoText
        infoText.setText("");
        // check if a friend is selected
        if(friendsList.getSelectionModel().getSelectedItem()==null) {
            infoText.setText("Error: No friend is selected!");
        }
        // delete the friend from the friends book
        else {
            int index = friendsList.getFocusModel().getFocusedIndex();
            Friend removed = book.getFriends().remove(index);
            // inform the deletion
            infoText.setText("Friend " + removed.getName() + " deleted from the Friends Book!");
            // display the new friend list
            ObservableList<String> friends = FXCollections.observableArrayList();
            for(Friend friend : book.getFriends()) {
                friends.add(friend.getName());
            }
            friendsList.setItems(friends);
        }
    }

    public void onDisplayButtonClick(ActionEvent actionEvent) {
        // clear the infoText
        infoText.setText("");
        // display friends in the list view
        ObservableList<String> friends = FXCollections.observableArrayList();
        for(Friend friend : book.getFriends()) {
            friends.add(friend.getName());
        }
        friendsList.setItems(friends);
    }

    public void onListClick(MouseEvent mouseEvent) {
        if(friendsList.getSelectionModel().getSelectedItem()!=null) {
            int index = friendsList.getSelectionModel().getSelectedIndex();
            Friend friend = book.getFriends().get(index);
            infoText.setText(friend.toString());
        }
    }
}