package ru.kolpakovee.querydsldemoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolpakovee.querydsldemoproject.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
