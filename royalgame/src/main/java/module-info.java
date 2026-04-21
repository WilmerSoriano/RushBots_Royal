module com.rushbot {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rushbot to javafx.fxml;
    exports com.rushbot;
}
