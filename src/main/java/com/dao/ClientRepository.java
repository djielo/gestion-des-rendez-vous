package com.dao;

import com.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    @Query(value = "select * from client c " +
            "join rendez_vous r  on r.id_client = c.id_client " +
           "join creneaux v on v.id_creneaux = r.id_creneaux " +
            "join medecins m on m.id_medecin = v.id_medecin " +
            "where m.id_medecin = :idMedecin",nativeQuery =true )
   Client findAllCkientOfMedecin(@Param ("idMedecin") int idMedecin);
}
