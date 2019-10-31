package edu.cnm.deepdive.stockrollersservice.dao;


import edu.cnm.deepdive.stockrollersservice.model.Stock;
import edu.cnm.deepdive.stockrollersservice.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface StockRepository extends CrudRepository<Stock, Long> {

  List<Stock> getAllByUsersContainingOrderByName(User user);

  List<Stock> getAllOrOrderByUsers(List<User> users);

}
