package services;

import java.util.List;
import repositories.AddresseRepository;
import entities.Addresse;

public class AddresseServices {
    AddresseRepository AddresseRepository=new AddresseRepository();
    public void ajouterAddresse(Addresse addresse){
        AddresseRepository.insert(addresse);
    }

    public List<Addresse> listerAddresses(){
        return AddresseRepository.selectAll();
    }

}
