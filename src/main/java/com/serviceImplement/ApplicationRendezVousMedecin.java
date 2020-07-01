package com.serviceImplement;

import com.entities.Client;
import com.entities.Creneaux;
import com.entities.Medecin;
import com.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ApplicationRendezVousMedecin implements CommandLineRunner {
    @Autowired
    private MedecinServiceImpl medecinServiceImpl;

    public void afficherMenu() {
        System.out.println
                ("\nCommandes (* pour arrêter) :\n" +
                        "1 : (getMedecins)\n" +
                        "2 : (getCreneauxMedecin) idMedecin\n" +
                        "3 : (getClients)\n" +
                        "4 : (getRvMedecinJour) idMedecin aaaa:mm:jj\n" +
                        "5 : (ajouterRvJourCreneauClient) aaaa:mm:jj idCreneau idClient\n" +
                        "6 : (supprimerRv) idRv\n"+
                        "7 : (chercher le medcin d'un client) idClient\n"+
                        "8: (chercher tous les clients d' un medecin \n "   );
    }

    @Override
    public void run(String... args) throws Exception {
        // medecinServiceImpl.getAllCreneauxByIdMedecin (1).forEach (System.out::println);
        // int idRendezVous = medecinServiceImpl.ajouterRendezVous ("2020-06-18",99,3);
        afficherMenu ();
        Scanner sc = new Scanner (System.in);
        String valeur = sc.nextLine ();
        while (!valeur.equals ("*")) {
            switch (valeur){
                case "1":
                    List<Medecin> medecins = medecinServiceImpl.getAllMedecins ();
                    for (Medecin md : medecins) {
                        System.out.println ("["+ md.getIdMedecin ()+","+md.getNomMedecin ()+","+md.getPreNomMedecin ()+"]");
                    }
                    break;
                case "2":
                    System.out.println ("saisir  l'id du medecin: \n");
                    Scanner sc2 = new Scanner (System.in);
                    int n = sc2.nextInt ();
                    List<Creneaux> creneaux = medecinServiceImpl.getAllCreneauxByIdMedecin (n);
                    System.out.println ("Liste des créneaux du médecin n°:"+n);
                    for(int i=0; i< creneaux.size (); i++) {
                        System.out.println ("["+creneaux.get (i).getIdCreaneaux ()+","+creneaux.get (i).getHeureDebut ()+","+creneaux.get (i).getHeureFin ());
                        Optional<Medecin> medecin = medecinServiceImpl.findMedecinById (n);
                        System.out.println (medecin.get ().getTitreMedecin ()+" "+medecin.get ().getNomMedecin ()+" à "+creneaux.size ());
                        System.out.println ("Mme PELISSIER a 24 créneaux.");
                    }
                    break;
                case "3":
                    List<Client> clients = medecinServiceImpl.getAllClient ();
                    System.out.println ("R");
                    for (Client cl : clients) {
                        System.out.println ("["+cl.getIdClient ()+","+cl.getTitreClient ()+","+cl.getNomClient ()+","+cl.getPreNomClient ());
                    }
                    break;
                case "4" :
                    Scanner sc3 = new Scanner (System.in);
                    System.out.println ("Renseignez l'id du medecin  : ");
                    int idMedecin = sc3.nextInt ();
                    Scanner sc4 = new Scanner (System.in);
                    System.out.println ("Renseignez la date (dd/MM/yyyy) : ");
                    SimpleDateFormat dateTimeFormatter  =  new SimpleDateFormat("dd/MM/yyyy");
                    String date = sc4.nextLine ();
                    Date dateConverti = dateTimeFormatter.parse (date);
                    List<RendezVous> rendezVousList = medecinServiceImpl.getRvMedecins (idMedecin, dateConverti);
                    rendezVousList.forEach (rendezvous  ->  System.out.println(rendezvous));
                    break;
                case "6" :
                    Scanner sc5 = new Scanner (System.in);
                    System.out.println ("Renseignez l'id du m à supprimer  ");
                    int n2 = sc5.nextInt ();
                    medecinServiceImpl.supprimerRendezVous (n2);
                    System.out.println ("Rendevous  numero " + n2 + " a été supprimé");
                case "5"  :
                    Scanner sc6= new Scanner (System.in);
                    System.out.println ("Renseignez la date du rendez-vous (dd/mm/yy) ");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-mm-dd");
                    String date1 = sc6.nextLine ();
                    Date dateRendezVous  = simpleDateFormat.parse (date1);
                    System.out.println (" Renseignez l' id du client du rendevous");
                    Scanner sc7 = new Scanner(System.in) ;
                    int idClent = sc7.nextInt ();
                    System.out.println ("Renseignez l' id du creneaux");
                    Scanner sc8 = new Scanner (System.in);
                    int idCreneaux = sc8.nextInt ();
                    int idRendezVousEnregistre = medecinServiceImpl.ajouterRendezVous (date1,idClent,idCreneaux);
                    System.out.println (" l' id du rendezVous enregistré est "+idRendezVousEnregistre);
                case "7":
                    Scanner sc9 = new Scanner (System.in);
                    System.out.println (" Renseignez l'identifiant du malade");
                    int idClient = sc9.nextInt ();
                    Medecin medecin = medecinServiceImpl.findMedecinByIdClient (idClient);
                    System.out.println ("le medecin cherché est \n"+medecin);
                case"8":
                    Scanner sc10 = new Scanner (System.in);
                    System.out.println (" Renseignez l' identifiant du medecin ");
                    int idMedecin1 = sc10.nextInt ();
                    Client client = medecinServiceImpl.findAllClientOfMedecin(idMedecin1);
                    System.out.println (" le client concerné est "+client);

            }
            afficherMenu ();
            valeur = sc.nextLine ();
        }

    }
}





