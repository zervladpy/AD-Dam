module com.zervlad.tallerpaco {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.sql;
    requires lombok;
    requires org.kordamp.bootstrapfx.core;

    opens com.zervlad.tallerpaco to javafx.fxml;
    opens com.zervlad.tallerpaco.Core.Entities.Car to org.hibernate.orm.core, javafx.base;
    opens com.zervlad.tallerpaco.Core.Entities.Customer to org.hibernate.orm.core, javafx.base;
    opens com.zervlad.tallerpaco.Core.Entities.Reciep to org.hibernate.orm.core, javafx.base;
    opens com.zervlad.tallerpaco.Core.Entities.Parts to org.hibernate.orm.core, javafx.base;

    opens com.zervlad.tallerpaco.Core.Session to org.hibernate.orm.core;


    exports com.zervlad.tallerpaco;
    exports com.zervlad.tallerpaco.Controllers;
    opens com.zervlad.tallerpaco.Controllers to javafx.fxml;
    exports com.zervlad.tallerpaco.Controllers.Car;
    opens com.zervlad.tallerpaco.Controllers.Car to javafx.fxml;
    exports com.zervlad.tallerpaco.Controllers.CarBrand;
    opens com.zervlad.tallerpaco.Controllers.CarBrand to javafx.fxml;
}