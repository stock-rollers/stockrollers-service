package edu.cnm.deepdive.stockrollersservice.model.dao;


import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

  List<User> getAllByOrderByName();

  List<User> getUsersByFollowsContaining(User user);

  List<User> getUsersByStocksContaining(Stock stock);

  List<User> getUserByFollowers(long followerId);

  List<User> getUsersByFollows(long followId);

  //List<User> getAllByStockId(long stockId);

  List<User> getAllByStocksContaining(Stock stock);

  Optional<User> getUserByOauthKey(String oauthKey);
}
