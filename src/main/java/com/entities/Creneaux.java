package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "creneaux")
public class Creneaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_creneaux")
    private int idCreaneaux;

    @Column(name = "heure_debut")
    private int heureDebut;

    @Column(name = "heure_fin")
    private int heureFin;

    @Column(name = "minutes_debut")
    private int minutesDebut;

    @Column(name = "minutes_fin")
    private int minutesFin;

    @ManyToOne
    @JoinColumn(name = "id_medecin")
    private Medecin medecin;


    public Creneaux() {
    }

    public Creneaux(int idCreaneaux, int heureDebut, int heureFin, int minutesDebut, int minutesFin, Medecin medecin) {
        this.idCreaneaux = idCreaneaux;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.minutesDebut = minutesDebut;
        this.minutesFin = minutesFin;
        this.medecin = medecin;
    }

    public int getIdCreaneaux() {
        return idCreaneaux;
    }

    public void setIdCreaneaux(int idCreaneaux) {
        this.idCreaneaux = idCreaneaux;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }

    public int getMinutesDebut() {
        return minutesDebut;
    }

    public void setMinutesDebut(int minutesDebut) {
        this.minutesDebut = minutesDebut;
    }

    public int getMinutesFin() {
        return minutesFin;
    }

    public void setMinutesFin(int minutesFin) {
        this.minutesFin = minutesFin;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    @Override
    public String toString() {
        return "Creneaux{" +
                "idCreaneaux=" + idCreaneaux +
                ", heureDebut=" + heureDebut +
                ", heureFin=" + heureFin +
                ", minutesDebut=" + minutesDebut +
                ", minutesFin=" + minutesFin +
                '}';
    }
}
