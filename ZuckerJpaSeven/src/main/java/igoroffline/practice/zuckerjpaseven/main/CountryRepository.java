package igoroffline.practice.zuckerjpaseven.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CountryRepository extends JpaRepository<Country, Integer>, QuerydslPredicateExecutor<Country> {
}
