package com.zervlad.tallerpaco.Controllers.Car;

import com.zervlad.tallerpaco.Core.DAO.CarDAO;
import com.zervlad.tallerpaco.Core.DAO.IDAO;
import com.zervlad.tallerpaco.Core.Entities.Car.Car;
import com.zervlad.tallerpaco.Core.Session.SessionManager;
import jakarta.persistence.EntityManagerFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CarController {

    private EntityManagerFactory emf;
    private IDAO<Car> dao;

    @FXML private TableView<Car> tableView;
    @FXML private TextField searchField;
    @FXML private Button addButton;

    public CarController() {
        // --- Initialize the EntityManagerFactory --- //
        this.emf = SessionManager.getInstance();
        // --- Initialize the DAO --- //
        this.dao = new CarDAO(emf);
    }

    public void initialize() {
        System.out.println("CarListViewController initialized");
        createTable();
        tableView.getItems().addAll(dao.getAll());
    }

    public void createTable() {

        // --- ID Column --- //
        TableColumn<Car, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        // --- License Plate Column --- //
        TableColumn<Car, String> licensePlateColumn = new TableColumn<>("Matrícula");
        licensePlateColumn.setCellValueFactory(new PropertyValueFactory<>("details.plate"));

        // --- Lineage Column --- //
        TableColumn<Car, String> lineageColumn = new TableColumn<>("Kilometraje");
        lineageColumn.setCellValueFactory(new PropertyValueFactory<>("details.mileage"));

        // --- Color Column --- //
        TableColumn<Car, String> colorColumn = new TableColumn<>("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("details.color"));

        // --- Add columns to table --- //
        List<TableColumn<Car, ?>> columns = tableView.getColumns();
        columns.addAll(List.of(idColumn, licensePlateColumn, lineageColumn, colorColumn));

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_NEXT_COLUMN);

    }
}
