package edu.cnm.deepdive.stockrollersservice.model.dao;

import edu.cnm.deepdive.stockrollersservice.model.entity.Industry;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface IndustryRepository extends CrudRepository<Industry, Long> {


}
