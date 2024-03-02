module com.zervlad.appnba {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires com.google.gson;


    exports com.zervlad.appnba.Presentation;
    opens com.zervlad.appnba.Presentation to javafx.fxml;
    exports com.zervlad.appnba.Core.Data.Team;
    opens com.zervlad.appnba.Core.Data.Team to org.hibernate.orm.core;
    exports com.zervlad.appnba.Core.Data.Player;
    opens com.zervlad.appnba.Core.Data.Player to org.hibernate.orm.core;
    exports com.zervlad.appnba.Core.Data.Game;
    opens com.zervlad.appnba.Core.Data.Game to org.hibernate.orm.core;
    exports com.zervlad.appnba.Core.Data.Statisitc;
    opens com.zervlad.appnba.Core.Data.Statisitc to org.hibernate.orm.core;
    exports com.zervlad.appnba.Core.Data.Country;
    opens com.zervlad.appnba.Core.Data.Country to org.hibernate.orm.core;

    exports com.zervlad.appnba.Core.Services;
    exports com.zervlad.appnba.Core.Interfaces;
    exports com.zervlad.appnba.Utils.Enums;

}