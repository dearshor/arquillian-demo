package org.arquillian.example.dao;

import org.arquillian.example.domain.Language;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
@Startup
public class LanguageDao {
    @PersistenceContext
    EntityManager em;

    public List<Language> listLanguages() {
        return em.createQuery("select l from Language l").getResultList();
    }

    @PostConstruct
    public void insertTestData() {
        Language java = new Language();
        java.setName("Java");
        em.persist(java);

        Language ruby = new Language();
        ruby.setName("Ruby");
        em.persist(ruby);

        Language groovy = new Language();
        groovy.setName("Groovy");
        em.persist(groovy);
    }
}