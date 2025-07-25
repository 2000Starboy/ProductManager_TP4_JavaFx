module ma.chakiri.productmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens ma.chakiri.productmanager to javafx.fxml;
    exports ma.chakiri.productmanager;
}