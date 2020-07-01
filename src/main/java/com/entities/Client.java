package com.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;

    @Column(name = "nom_client")
    private String nomClient;

    @Column(name = "prenom_client")
    private String preNomClient;

    @Column(name = "titre_client")
    private String titreClient;

    @OneToMany (mappedBy = "client",fetch = FetchType.EAGER)
    public List<RendezVous> rendezVousList = new ArrayList<> ();

    public Client() {
    }

    public Client(int idClient, String nomClient, String preNomClient, String titreClient) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.preNomClient = preNomClient;
        this.titreClient = titreClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPreNomClient() {
        return preNomClient;
    }

    public void setPreNomClient(String preNomClient) {
        this.preNomClient = preNomClient;
    }

    public String getTitreClient() {
        return titreClient;
    }

    public void setTitreClient(String titreClient) {
        this.titreClient = titreClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nomClient='" + nomClient + '\'' +
                ", preNomClient='" + preNomClient + '\'' +
                ", titreClient='" + titreClient + '\'' +
                '}';
    }
}
