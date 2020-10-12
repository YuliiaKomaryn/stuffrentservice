package services;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import services.models.Stuff;
import services.repository.StuffRepository;


import java.util.List;

import java.util.Optional;



@Service

public class StuffRentService implements IStuffRentService {

    @Autowired

    private StuffRepository repository;



    @Override

    public List<Stuff> findAll() {

        return (List<Stuff>) repository.findAll();

    }



    @Override

    public Stuff save(Stuff swimmingStuffForSave) {

        return repository.save(swimmingStuffForSave);

    }



    @Override

    public Stuff getById(String id) throws NotFoundException {

        Optional<Stuff> tempSwimmingStuff = repository.findById(id);

        if (tempSwimmingStuff.isPresent())

            return repository.findById(id).get();

        else

            throw new NotFoundException(String.format("Swimming Stuff with id %s does not exist", id));

    }



    @Override

    public void deleteById(String id) throws NotFoundException {

        repository.delete(getById(id));

    }

}