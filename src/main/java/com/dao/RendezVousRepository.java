package com.dao;

import com.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Integer> {
    @Query(value = "select r from RendezVous r  " +
            " where r.creneaux.medecin.idMedecin = :idMedecin and r.jour = :date")
    public List<RendezVous> getRvMedecinbyIdMedecin(@Param("idMedecin") int idMedecin, @Param ("date") Date date);

//    @Query(value = "select * from rendez_vous r  " +
//            " join creneaux c on c.id_creneaux = r.id_creneaux" +
//            " join medecins m on m.id_medecin = c.id_medecin " +
//            " where m.id_medecin = :idMedecin and r.jour = :date ", nativeQuery  = true)
//    public List<RendezVous> getRvMedecinbyIdMedecin(@Param("idMedecin") int idMedecin, @Param ("date") Date date);


 /*   // utiliser join  car on a une liste creneaux
    @Query(value = "select r from RendezVous r join r.creneaux c " +
            " where c.medecin.idMedecin = :idMedecin and r.jour = :date")
    public List<RendezVous> getRvMedecinbyIdMedecin(@Param("idMedecin") int idMedecin, @Param ("date") Date date);
*/
}
