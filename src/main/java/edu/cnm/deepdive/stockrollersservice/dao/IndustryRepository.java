package edu.cnm.deepdive.stockrollersservice.dao;

import edu.cnm.deepdive.stockrollersservice.model.Industry;
import edu.cnm.deepdive.stockrollersservice.model.Stock;
import edu.cnm.deepdive.stockrollersservice.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface IndustryRepository extends CrudRepository {


  Industry getAllOrOrderByName(Stock stock);
}
