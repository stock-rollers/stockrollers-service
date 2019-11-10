package edu.cnm.deepdive.stockrollersservice.model.dao;

import edu.cnm.deepdive.stockrollersservice.model.entity.Industry;
import io.reactivex.Single;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface IndustryRepository extends CrudRepository<Industry, Long> {
  //No additional methods needed
}
