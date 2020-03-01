module mea {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mymealiving to javafx.fxml;
    exports com.mymealiving;
}