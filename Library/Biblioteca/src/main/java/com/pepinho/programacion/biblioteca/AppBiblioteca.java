package com.pepinho.programacion.biblioteca;

import com.pepinho.programacion.biblioteca.controller.BookController;
import com.pepinho.programacion.biblioteca.controller.IBookController;
import com.pepinho.programacion.biblioteca.model.*;
import com.pepinho.programacion.biblioteca.view.BookView;
import com.pepinho.programacion.biblioteca.view.IBookView;

import static com.pepinho.programacion.biblioteca.model.DAOFactory.Provider.H2;
import static com.pepinho.programacion.biblioteca.model.DAOFactory.Provider.HIBERNATE;

public class AppBiblioteca {


    public static void main(String[] args) {

        EntityManagerUtil entityManagerUtil = EntityManagerUtil.getInstance();

        DAO<Book> bookDAO = new DAOFactory(entityManagerUtil).getBookDAO(HIBERNATE);

        IBookController bookController = BookController.getInstance();
        bookController.setDao(bookDAO);
        IBookView bookView =  new BookView(bookController);

        bookView.setVisible(true);

    }

}
