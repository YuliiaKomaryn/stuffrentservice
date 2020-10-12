package services;



import javassist.NotFoundException;
import services.models.Stuff;


import java.util.List;



public interface IStuffRentService {

    List<Stuff> findAll();



    Stuff save(Stuff swimmingStuffForSave);



    Stuff getById(String id) throws NotFoundException;



    void deleteById(String id) throws NotFoundException;

}
