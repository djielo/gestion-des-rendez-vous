package com.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

// medecin -> creneaux
// creneaux -> medecin
// rdv -> creneaux
@Entity
@Table(name = "rendez_vous")
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " id_rendez_vous")
    private int idRendevous;

    @Column(name = "jour")
    private Date jour;

    @OneToOne
    @JoinColumn(name = "id_creneaux")
    private Creneaux creneaux;

//    @OneToMany
//    @JoinColumn(name = "id_creneaux")
//    private List<Creneaux> creneaux;
//



    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    public RendezVous() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getIdRendevous() {
        return idRendevous;
    }

    public void setIdRendevous(int idRendevous) {
        this.idRendevous = idRendevous;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Creneaux getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(Creneaux creneaux) {
        this.creneaux = creneaux;
    }


    @Override
    public String toString() {
        return "RendezVous{" +
                "idRendevous=" + idRendevous +
                ", creneaux=" + creneaux +
                ", client=" + client +
                '}';
    }


}
