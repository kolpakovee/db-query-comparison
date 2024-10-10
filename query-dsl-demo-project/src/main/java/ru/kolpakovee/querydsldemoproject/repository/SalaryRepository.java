package ru.kolpakovee.querydsldemoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolpakovee.querydsldemoproject.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
