package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Addresse;
import entities.Client;

public class AddresseRepository {
     public void insert(Addresse addresse){
        
      }

      public List<Addresse> selectAll(){
         List<Addresse> comptes=new ArrayList<>();
          try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir" 
                   , "root", "root");
             Statement statement = conn.createStatement();
             String sql="SELECT * FROM `addresse` c, client cl,compte a WHERE c.client_id=cl.id_client and c.compte_id=a.id_ad;";
             ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
                Client client=new Client();
                client.setId(rs.getInt("id_client"));
                client.setNomComplet(rs.getString("nomComplet_client"));
                client.setEmail(rs.getString("Email_client"));
                client.setTelephone(rs.getString("telephone_client"));

                 Addresse ag=new Addresse();
                 ad.setId(rs.getInt("id_ad"));
                 ad.setNumVilla(rs.getString("numVilla_ad"));
                 ad.setVille(rs.getString("ville_ad"));
                 ad.setQuartier(rs.getString("telephone_ad"));
            
    
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
       return  comptes;
      }
}

}
