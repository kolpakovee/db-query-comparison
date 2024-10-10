package ru.kolpakovee.querydsldemoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolpakovee.querydsldemoproject.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
