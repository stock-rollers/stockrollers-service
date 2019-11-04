package edu.cnm.deepdive.stockrollersservice.model.dao;

import edu.cnm.deepdive.stockrollersservice.model.entity.Industry;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import org.springframework.data.repository.CrudRepository;


public interface IndustryRepository extends CrudRepository {


  Industry getAllOrOrderByName(Stock stock);
}
