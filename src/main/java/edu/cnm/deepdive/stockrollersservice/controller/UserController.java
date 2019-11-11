package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.UserRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.entity.User;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Gets followers of a user.
   */
  @GetMapping(value = "{id}/followers", produces = MediaType.APPLICATION_JSON_VALUE)
  public Set<User> getFollowers(@PathVariable long id) {
    return get(id).getFollowers();
  }

  /**
   * Gets who a user is following.
   *
   * @param id
   * @return
   */
  @GetMapping(value = "{id}/follows", produces = MediaType.APPLICATION_JSON_VALUE)
  public Set<User> getFollows(@PathVariable long id) {
    return get(id).getFollows();
  }

  /**
   * Gets single user.
   *
   * @param id
   * @return
   */
  @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public User get(@PathVariable long id) {
    return userRepository.findById(id).get();
  }

  /**
   * Gets a list of all users.
   *
   * @return
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> get() {
    return userRepository.getAllByOrderByName();
  }

  /**
   * Adds a follower of a user to the database.
   * @param user
   * @return
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public User addFollow(@RequestBody User user) {
    return userRepository.save(user);
  }

  /**
   * Updates a user.
   * @param user
   * @return
   */
  @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public User updateUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  /**
   * Deletes a follower of a user.
   * @param id
   */
  @DeleteMapping(value = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable long id) {
    userRepository.findById(id).ifPresent(userRepository::delete);
  }

  /**
   * Returns a 404 not found if a NoSuchElementException is thrown.
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(Exception.class)
  public void badRequest() {
  }

}
