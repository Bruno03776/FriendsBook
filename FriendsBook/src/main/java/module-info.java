module com.example.friendsbook {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.friendsbook to javafx.fxml;
    exports com.example.friendsbook;
}