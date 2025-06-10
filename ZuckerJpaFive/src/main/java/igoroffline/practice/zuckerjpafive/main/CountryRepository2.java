package igoroffline.practice.zuckerjpafive.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository2 {

    @PersistenceContext
    private final EntityManager entityManager;

    public CountryRepository2(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Country getCountryTemp() {

        TypedQuery<Country> query = entityManager.createQuery("select c from Country c where c.id = 38", Country.class);
        return query.getSingleResult();
    }

    public List<Country> getCountryByCountryContainingIgnoreCase2(String country) {

        TypedQuery<Country> query = entityManager.createQuery("select c from Country c where c.country ilike :country", Country.class);
        return query.setParameter("country", country).getResultList();
    }

    public List<Country> getCountryCriteriaBuilderPractice() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> cq = cb.createQuery(Country.class);
        Root<Country> root = cq.from(Country.class);
        cq.where(cb.like(cb.lower(root.get("country")), "germany"));
        TypedQuery<Country> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
