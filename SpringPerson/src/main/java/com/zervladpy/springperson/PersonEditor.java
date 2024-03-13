package com.zervladpy.springperson;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class PersonEditor extends VerticalLayout implements KeyNotifier {
    private final PersonRepository repository;
    private Person person;
    TextField name = new TextField("Name");
    TextField surname = new TextField("Surname");

    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);
    Binder<Person> binder = new Binder<>(Person.class);
    // ChangeHandler es notificado cuando guardas o borras haciendo clic.
    @Setter
    private ChangeHandler changeHandler;


    public interface ChangeHandler {
        void onChange();
    }

    public void save() {
        repository.save(person);
        changeHandler.onChange();
    }

    public void delete() {
        repository.delete(person);
        changeHandler.onChange();
    }

    @Autowired
    public PersonEditor(PersonRepository repository) {
        this.repository = repository;
        add(name, surname, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        save.getElement().getThemeList().add("primary");
        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editUsuario(person));
        setVisible(false);
    }

    public final void editUsuario(Person c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean existePersistido = c.getId() != null;
        if (existePersistido) {
            // Busca la entidad actualizada con el mismo ID
            // En una aplicación del mundo real, esto debería comprobar si realmente existe en la base de datos
            // Con carga perezosa para las relaciones con la entidad.
            person = repository.findById(c.getId()).get();
        }
        else {
            person = c;
        }
        cancel.setVisible(existePersistido);

        // Enlaza las propiedades del usuario con los nombres similares de los nombres de los campos.
        // Podría usaser una anotación o "manual binding" o por medio de programación
        // moviendo los valores de los campos a la entidad y viceversa.
        binder.setBean(person);

        setVisible(true);

        // Enfoca el nombre inicialmente
        name.focus();
    }

}
