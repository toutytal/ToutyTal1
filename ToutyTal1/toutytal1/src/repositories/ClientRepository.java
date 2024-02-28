package repositories;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Client;

public class ClientRepository {
       public void insert(Client client){
        try {
    
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir" 
                    , "root", "root");
            Statement statement = conn.createStatement();
          
             String sql=String.format("INSERT INTO `client` (`nomComplet_client`, `Email_client`, `telephone_client`,, `Email_client`) "
                      + " VALUES ('%s', '%s', '%s','%s')",
                      client.getNomComplet(),client.getEmail(),client.getTelephone(),client.getId());
             int nbreLigne=statement.executeUpdate(sql);
             statement.close();
             conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        }
       catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
      }
      }

      public List<Client> selectAll(){
         List<Client> clients=new ArrayList<>();
        try {
    
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir" 
                   , "root", "root");
           Statement statement = conn.createStatement();
           String sql="Select * from client";
           ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {

                Client client=new Client();
                client.setId(rs.getInt("id_client"));
                client.setNomComplet(rs.getString("nomComplet_client"));
                client.setEmail(rs.getString("Email_client"));
                client.setTelephone(rs.getString("telephone_client"));
                clients.add(client);
            }
            statement.close();
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement de Driver");
       }
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
       return clients;
      }
      public Client selectClientByTel(String tel){
        Client client=null;
        try {
    
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir" 
                   , "root", "root");
           Statement statement = conn.createStatement();
           String sql=String.format("Select * from client where tel_client like '%s' ",tel);
           ResultSet rs=statement.executeQuery(sql);
            if (rs.next()) {
                Client client2=new Client();
                client.setId(rs.getInt("id_client"));
                client.setNomComplet(rs.getString("nomComplet_client"));
                client.setEmail(rs.getString("Email_client"));
                client.setTelephone(rs.getString("telephone_client"));
                client2.add(client2);
            
            }
            statement.close();
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement de Driver");
       }
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
           return client;
      }
}
