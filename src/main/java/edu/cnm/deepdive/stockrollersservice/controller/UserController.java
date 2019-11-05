package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.UserRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> get(@RequestParam("stock") long stockId) {
    return userRepository
        .getAllByStockId(stockId); //Gets all users associated with a specific stock.
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> getFollower(long followerId) {
    return userRepository.getUserByFollowers(followerId);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> getFollow(long followId) {
    return userRepository.getUsersByFollows(followId);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> get(Stock stock) {
    return userRepository.getUsersByStocksContaining(stock);
  }

  //TODO Postmapping to get User input then display all followers and follows.
}
