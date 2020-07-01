package com.service;

import com.entities.Client;
import com.entities.Creneaux;
import com.entities.Medecin;
import com.entities.RendezVous;
import com.exception.ClientNotFoundException;
import com.exception.CreneauxException;
import com.exception.MedecinNotFoundException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MedecinService {
    public List<Medecin> getAllMedecins();

    public List<Client> getAllClient();

    public List<Creneaux> getAllCreneauxByIdMedecin (int idmedecin);

    public List<RendezVous> getAllRendezVous();

    public  int ajouterRendezVous(String jour, int idclient, int idCreneax) throws Exception;

    public void supprimerRendezVous(int idRendezVvous);
    public Optional<Medecin> findMedecinById(int idMedecin) throws MedecinNotFoundException;
    public Optional<Client> findClientById(int idClient) throws ClientNotFoundException;
    public Optional<Creneaux> findById(int idCreneaux) throws CreneauxException;
    public List<RendezVous> getRvMedecins(int idMedecin, Date date);
    public Medecin findMedecinByIdClient(int idClient);
    public Client findAllClientOfMedecin(int idMedecin);



}
