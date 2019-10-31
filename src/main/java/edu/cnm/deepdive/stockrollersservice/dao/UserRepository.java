package edu.cnm.deepdive.stockrollersservice.dao;


import edu.cnm.deepdive.stockrollersservice.model.Stock;
import edu.cnm.deepdive.stockrollersservice.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

  List<User> getUsersByStocksContaining(Stock stock);

  List<User> getUserByFollowers(User user);

  List<User> getUsersByFollows(User user);

}
