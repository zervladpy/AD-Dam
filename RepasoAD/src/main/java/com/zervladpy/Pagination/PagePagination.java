package com.zervladpy.Pagination;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.hibernate.Remove;

import java.util.List;

public class PagePagination<T> {
    private final EntityManager em;
    private String queryName;
    private int actualPage;
    private long totalResults;
    @Getter
    private int pageSize;

    private Class<T> resultClass;

    public PagePagination(EntityManager em) {
        this.em = em;
    }

    public long getTotalPages() {
        return totalResults / pageSize;
    }

    public void init(String queryName, String recountQueryName, int pageSize, Class<T> resultClass) {
        this.queryName = queryName;
        this.pageSize = pageSize;
        this.actualPage = 0;
        this.totalResults = em.createNamedQuery(recountQueryName, Long.class).getSingleResult();
        actualPage = 0;
        this.resultClass = resultClass;
    }

    public void nextPage() {
        if (actualPage < getTotalPages()) {
            actualPage++;
        }
    }

    public void previousPage() {
        if (actualPage > 0) {
            actualPage--;
        }
    }

    public List<T> getActualPage() {
        return em.createNamedQuery(queryName, resultClass)
                .setFirstResult(actualPage * pageSize)
                .setMaxResults(pageSize).getResultList();
    }

    @Remove
    public void finish() {

    }
}
