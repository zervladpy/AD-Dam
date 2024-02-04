
package com.pepinho.programacion.biblioteca;

import com.pepinho.programacion.biblioteca.model.*;
import com.pepinho.programacion.biblioteca.model.H2.BookH2DAO;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;


public class AppInsertContido {

    public static final String RUTA = "D:\\Clase\\AD-DAM2\\Library\\database\\biblioteca";

    public static InputStream getCover(String archivo) {
        try {
            return Files.newInputStream(Path.of(RUTA + archivo + ".jpg"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static byte[] getCoverBytes(String archivo) {
        try (var fis  = Files.newInputStream(Path.of(RUTA + archivo + ".jpg"))){
            return fis.readAllBytes();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {

        EntityManagerUtil connectionLibrary = EntityManagerUtil.getInstance();

        Connection con = connectionLibrary.getConnection();

        ContidoDAO contidoDAO = new ContidoDAO(con);

        BookH2DAO bookH2DAO = new BookH2DAO(con);


        // Inserto un libro de ejemplo
        // Ojo, debe existir la carpeta E:\98 - Bases de datos\biblioteca\bookscovers y cambiadla por la vuestra
//        Book book = new Book("9788424159535", "El dador", "Lowry Lois", 1993, true,
//                getCoverBytes("9788424159535"));
//        bookDAO.save(book);

        Book book = new Book("9788418067952", "Ariel", "Sylvia Plath", 2021, false,
                getCoverBytes("9788418067952"));
        bookH2DAO.save(book);
        // debo recuperar el id del libro para poder insertar los contenidos
        long idBook = book.getIdBook();



        try (var br = Files.newBufferedReader(Path.of("E:\\98 - Bases de datos\\biblioteca\\" +
                "9788418067952.txt"));) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Creo el objeto contido
                Contido contido = new Contido(idBook, linea);
                // Lo guardo en la base de datos
                contidoDAO.save(contido);
                // Lo recupero de la base de datos
                contidoDAO.get(contido.getIdContido());
                // Lo muestro por pantalla
                System.out.println(contido);
            }


        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }


    }

}
