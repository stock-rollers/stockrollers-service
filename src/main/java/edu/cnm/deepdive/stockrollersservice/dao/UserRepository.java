package edu.cnm.deepdive.stockrollersservice.dao;


import edu.cnm.deepdive.stockrollersservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
