module mea {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.mymealiving to javafx.fxml;
    exports com.mymealiving;
}