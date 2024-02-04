package com.pepinho.programacion.biblioteca.model.Hibernate;

import com.pepinho.programacion.biblioteca.model.Book;
import com.pepinho.programacion.biblioteca.model.DAO;
import com.pepinho.programacion.biblioteca.model.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookHibernateDAO implements DAO<Book> {

    private final EntityManagerFactory emf;

    public BookHibernateDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Book get(long id) {
        EntityManager em = emf.createEntityManager();

        Book book = em.find(Book.class, Math.toIntExact(id));

        em.close();

        return book;
    }

    @Override
    public List<Book> getAll() {
        EntityManager em = emf.createEntityManager();

        // Use a JPQL query to retrieve all books
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        List<Book> books = query.getResultList();

        em.close();

        return books;
    }

    @Override
    public void save(Book book) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(book);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Book book) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // Merge the book entity
            em.merge(book);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Book book) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // Remove the book entity
            em.remove(em.contains(book) ? book : em.merge(book));

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteById(long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // Find the book by ID and remove it
            Book book = em.find(Book.class, id);
            if (book != null) {
                em.remove(book);
                transaction.commit();
                return true;
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

        return false;
    }

    @Override
    public List<Integer> getAllIds() {
        EntityManager em = emf.createEntityManager();

        // Use a JPQL query to retrieve all book IDs
        TypedQuery<Integer> query = em.createQuery("SELECT b.idBook FROM Book b", Integer.class);
        List<Integer> bookIds = query.getResultList();

        em.close();

        return bookIds;
    }

    @Override
    public void updateLOB(Book book, String f) {
        // Implement as needed
    }

    @Override
    public void updateLOBById(long id, String f) {
        // Implement as needed
    }

    @Override
    public void deleteAll() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // Use JPQL to delete all records from the Book table
            em.createQuery("DELETE FROM Book").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
