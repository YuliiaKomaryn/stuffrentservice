package services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import services.models.Stuff;


@Repository
public interface StuffRepository extends CrudRepository<Stuff, String> {

}