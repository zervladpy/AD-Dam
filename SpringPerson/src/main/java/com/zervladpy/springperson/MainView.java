package com.zervladpy.springperson;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private final PersonRepository repository;
    private final PersonEditor editor;

    final Grid<Person> userGrid;

    final TextField filtro;

    private final Button addNewBtn;

    public MainView(PersonRepository repository, PersonEditor editor) {
        this.repository = repository;
        this.editor = editor;
        this.userGrid = new Grid<>(Person.class);
        this.filtro = new TextField();
        this.addNewBtn = new Button("Nuevo usuario", VaadinIcon.PLUS.create());

        // Disposición de los componentes:
        HorizontalLayout accionesLayout = new HorizontalLayout(filtro, addNewBtn);
        add(accionesLayout, userGrid, editor);

        userGrid.setHeight("300px");
        userGrid.setColumns("idUsuario", "nombre", "apellidos");
        userGrid.getColumnByKey("idUsuario").setWidth("50px").setFlexGrow(0);

        filtro.setPlaceholder("Filtrar por apellidos");

        // Enlace de la lógica con los componentes

        // Sustituye el listado cuando se aplica un filtro:
        filtro.setValueChangeMode(ValueChangeMode.LAZY);
        filtro.addValueChangeListener(e -> listPersons(e.getValue()));

        // Conecta el Usuario seleccionado al editor o lo oculta si no está seleccionado
        userGrid.asSingleSelect().addValueChangeListener(e -> {
            editor.editUsuario(e.getValue());
        });

        // Instancia y edita un nuevo Usuario cuando se pulsa el botón "Nuevo Usuario"
        addNewBtn.addClickListener(e -> editor.editUsuario(new Person("", "")));

        // Escucha los cambios hechos por el editor, refresca los datos del modelo.
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listPersons(filtro.getValue());
        });

        // Inicializa el listado
        listPersons("");
    }

    private void listPersons(String value) {
        if (value.isEmpty()) {
            userGrid.setItems(repository.findAll());
        } else {
            userGrid.setItems(repository.findByNameStartsWithIgnoreCase(value));
        }
    }

    private void listUsers() {
        userGrid.setItems(repository.findAll());
    }


}
