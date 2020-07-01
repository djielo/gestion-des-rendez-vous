package com.serviceImplement;

import com.dao.ClientRepository;
import com.dao.CreneauxRepository;
import com.dao.MedecinRepository;
import com.dao.RendezVousRepository;
import com.entities.Client;
import com.entities.Creneaux;
import com.entities.Medecin;
import com.entities.RendezVous;
import com.exception.ClientNotFoundException;
import com.exception.CreneauxException;
import com.exception.MedecinNotFoundException;
import com.service.MedecinService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MedecinServiceImpl implements MedecinService {
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CreneauxRepository creneauxRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll ();
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll ();
    }

    @Override
    public List<Creneaux> getAllCreneauxByIdMedecin(int idMedecin) {
        Optional<Medecin> medecin = medecinRepository.findById (idMedecin);
        if (medecin.isPresent ()) {
            Medecin medecin1 = medecin.get ();
            return medecin1.getCreneauxList ();
        } else {
            return new ArrayList<> ();
        }
    }

    @Override
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll ();
    }

    @Override
    public int ajouterRendezVous(String jour, int idclient, int idCreneaux) throws Exception {
        Optional<Client> client = clientRepository.findById (idclient);
        Optional<Creneaux> creneaux = creneauxRepository.findById (idCreneaux);
        RendezVous rendezVous = new RendezVous ();
        if (client.isPresent () && creneaux.isPresent ()) {
            rendezVous.setClient (client.get ());
            rendezVous.setCreneaux (creneaux.get ());
            Date date = new SimpleDateFormat ("yyyy-mm-dd").parse (jour);
            rendezVous.setJour (date);
            System.out.println ("ca marche");
            RendezVous rendezVousSave = rendezVousRepository.save (rendezVous);
            return rendezVousSave.getIdRendevous ();
        }

        throw new Exception ("client ou creneau non present");
    }

    @Override
    public void supprimerRendezVous(int idRendezVvous) {
        rendezVousRepository.deleteById (idRendezVvous);

    }

    @Override
    public Optional<Medecin> findMedecinById(int idMedecin) throws MedecinNotFoundException {
        Optional<Medecin> medecin = medecinRepository.findById (idMedecin);
        if (!medecin.isPresent ()) throw new MedecinNotFoundException ("Medecin introvable");
        return medecin;
    }

    @Override
    public Optional<Client> findClientById(int idClient) throws ClientNotFoundException {
        Optional<Client> client = clientRepository.findById (idClient);
        if (!client.isPresent ()) throw new ClientNotFoundException ("Client introuvable");
        return client;
    }

    @Override
    public Optional<Creneaux> findById(int idCreneaux) throws CreneauxException {
        Optional<Creneaux> creneaux = creneauxRepository.findById (idCreneaux);
        if (!creneaux.isPresent ()) throw new CreneauxException ("creneaux introuvable");
        return creneaux;
    }

    @Override
    public List<RendezVous> getRvMedecins(int idMedecin, Date date)  {
          return rendezVousRepository.getRvMedecinbyIdMedecin (idMedecin, date);
    }

    @Override
    public Medecin findMedecinByIdClient(int idClient) {
        return medecinRepository.findMedecinByIdClient (idClient);
    }

    @Override
    public Client findAllClientOfMedecin(int idMedecin) {
        return clientRepository.findAllCkientOfMedecin (idMedecin);
    }


}