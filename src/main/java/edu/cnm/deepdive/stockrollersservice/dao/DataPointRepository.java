package edu.cnm.deepdive.stockrollersservice.dao;

import edu.cnm.deepdive.stockrollersservice.model.User;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface DataPointRepository extends CrudRepository {

  Optional<User> 


  public List<LocalDate> getClosingprice(float x);

}
