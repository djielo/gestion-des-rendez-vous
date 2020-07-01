package com.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medecins")
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medecin")
    private int idMedecin;

    @Column(name = "nom_medecin")
    private String nomMedecin;

    @Column(name = "prenom_medecin")
    private String preNomMedecin;
    @Column(name = "titre_medecin")
    private String titreMedecin;

    @OneToMany(mappedBy="medecin", fetch = FetchType.EAGER)
    @JsonBackReference
    public List<Creneaux> creneauxList = new ArrayList<> ();

    public Medecin() {
    }

    public Medecin(int idMedecin, String nomMedecin, String preNomMedecin, String titreMedecin) {
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
        this.preNomMedecin = preNomMedecin;
        this.titreMedecin = titreMedecin;
    }

    public List<Creneaux> getCreneauxList() {
        return creneauxList;
    }

    public void setCreneauxList(List<Creneaux> creneauxList) {
        this.creneauxList = creneauxList;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getPreNomMedecin() {
        return preNomMedecin;
    }

    public void setPreNomMedecin(String preNomMedecin) {
        this.preNomMedecin = preNomMedecin;
    }

    public String getTitreMedecin() {
        return titreMedecin;
    }

    public void setTitreMedecin(String titreMedecin) {
        this.titreMedecin = titreMedecin;
    }

    @Override
    public String toString() {
        return "Medecin{" +
                "idMedecin=" + idMedecin +
                ", nomMedecin='" + nomMedecin + '\'' +
                ", preNomMedecin='" + preNomMedecin + '\'' +
                ", titreMedecin='" + titreMedecin + '\'' +
                '}';
    }
}
