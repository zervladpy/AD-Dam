package com.zervlad.tallerpaco.Controllers;

import com.zervlad.tallerpaco.Controllers.CreateCarScene.CreateCarScene;
import com.zervlad.tallerpaco.Core.Entities.Car.CarBrand;
import com.zervlad.tallerpaco.Core.Entities.Customer.Customer;
import com.zervlad.tallerpaco.Core.Entities.Parts.Part;
import com.zervlad.tallerpaco.Core.Entities.Reciep.Receipt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    // --- Car Brand --- //
    @FXML
    Button addCarBrandButton;
    @FXML
    TextField searchCarBrand;
    @FXML
    ListView<CarBrand> model_car_list_view;

    // --- Cars --- //
    @FXML
    Button addBrandButton;
    @FXML
    TextField searchBrandTextField;
    @FXML
    TableView<CarBrand> brandTable;

    // --- Customers --- //
    @FXML
    Button addCustomerButton;
    @FXML
    TextField searchCustomerTextField;
    @FXML
    TableView<Customer> customerTable;

    // --- Receipts --- //
    @FXML
    Button addReceiptButton;
    @FXML
    TextField searchReceiptTextField;
    @FXML
    TableView<Receipt> receiptTable;

    // --- Parts --- //
    @FXML
    Button addPartButton;
    @FXML
    TextField searchPartTextField;
    @FXML
    TableView<Part> partTable;

    // --- New Registry --- //
    @FXML
    Button newRegistryButton;

    private void initialize() {
        setButtonListeners();
    }

    private void setButtonListeners() {
        // --- CAR --- //
        addCarBrandButton.setOnAction(event -> {});
        // --- BRAND --- //
        addBrandButton.setOnAction(event -> {});
        // --- CUSTOMER --- //
        addCustomerButton.setOnAction(event -> {});
        // --- RECEIPT --- //
        addReceiptButton.setOnAction(event -> {});
        // --- PART --- //
        addPartButton.setOnAction(event -> {});
        // --- NEW REGISTRY --- //
        newRegistryButton.setOnAction(event -> {});
    }

}