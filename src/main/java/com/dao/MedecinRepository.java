package com.dao;

import com.entities.Medecin;
import com.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Integer> {
    @Query(value = "select r from RendezVous r " +
            " where r.creneaux.medecin.idMedecin = :idMedecin and r.jour = :date")
    public List<RendezVous> getRvMedecinbyIdMedecin(@Param ("idMedecin") int idMedecin, @Param ("date") Date date);

    // chercher le medecin qui suit un malade
    @Query(value = "select * from medecins m "+
    " join creneaux c on c.id_medecin = m.id_medecin "+
    "join rendez_vous r on r.id_creneaux = c.id_creneaux "+
    "join client v on  r.id_client = v.id_client "+
    "where v.id_client = :idClient",nativeQuery = true)
    Medecin findMedecinByIdClient(@Param ("idClient") int idClient);


}
