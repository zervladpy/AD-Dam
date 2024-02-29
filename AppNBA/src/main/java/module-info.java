module com.zervlad.appnba {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;


    exports com.zervlad.appnba.Presentation;
    opens com.zervlad.appnba.Presentation to javafx.fxml;
}