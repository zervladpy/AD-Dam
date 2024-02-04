package com.pepinho.programacion.biblioteca.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-27T19:57:35", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Integer> ano;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile SingularAttribute<Book, Boolean> available;
    public static volatile SingularAttribute<Book, Integer> idBook;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, byte[]> portada;

}