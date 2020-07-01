package com.dao;

import com.entities.Creneaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreneauxRepository extends JpaRepository<Creneaux,Integer> {
}
