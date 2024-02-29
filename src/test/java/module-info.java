module git.gavinkeys.testautomation_demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens git.gavinkeys.testautomation_demo to javafx.fxml;
    exports git.gavinkeys.testautomation_demo;
}