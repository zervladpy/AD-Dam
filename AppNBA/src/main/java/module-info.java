module com.zervlad.appnba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zervlad.appnba to javafx.fxml;
    exports com.zervlad.appnba;
}