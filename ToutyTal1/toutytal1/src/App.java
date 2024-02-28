import java.util.List;
import java.util.Scanner;

import entities.Client;
import services.AddresseServices;
import services.ClientServices;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);

    
        ClientServices ClientService=new ClientServices();
        AddresseServices AddresseServices=new AddresseServices();
       
        do { 
            System.out.println("1-Creer un  Client");
            System.out.println("2-Lister Toutes les Clients"); 
            System.out.println("3-");
            System.out.println("4-"); 
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
             System.out.println("Entrer le Telephone");
             telephone=sc.nextLine();
             String nom,prenom;
             Client client= ClientServices.rechercherClientParTel(telephone);
    
             if (client!=null) {
                  System.out.println("Ce numero de Telephone existe deja");
             } else {
                 System.out.println("Entrer un Nom");
                 nom=sc.nextLine(); 
                 client=new Client();
                 client.setNomComplet(nom);
                 client.setTelephone(telephone);
                 ClientServices.ajouterClient(client);
             }
             break;
             case 2:
                  List<Client> clients= ClientServices.listerClient();
                   for (Client cl: clients) {
                     System.out.println("nomComplet "+ cl.getNomComplet());
                     System.out.println("Telephone "+cl.getTelephone() );
                     System.out.println("Email "+cl.getEmail() );
                     System.out.println("=================================");
               }
                    break;
                }
                 
    }

}



