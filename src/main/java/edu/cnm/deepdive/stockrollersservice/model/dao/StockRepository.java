package edu.cnm.deepdive.stockrollersservice.model.dao;

import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {

  List<Stock> getAllByUsersContainingOrderByName(User user);

  @Query(value = "SELECT s FROM stock st INNER JOIN stock_share sh ON sh.stock_id = st.stock_id WHERE sh.user_id = :userId ORDER BY st.name", nativeQuery = true)
  List<Stock> getAllByUserId(long userId);

  List<Stock> getAllOrderByUsers(List<User> users);

  List<Stock> getAllByIndustryId(long industryId);

}
