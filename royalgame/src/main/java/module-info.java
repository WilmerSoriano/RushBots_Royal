module com.rushbot {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;

    opens com.rushbot to javafx.fxml;
    exports com.rushbot;
}
