package edu.cnm.deepdive.stockrollersservice.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import edu.cnm.deepdive.stockrollersservice.model.dao.UserRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


  private final UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User getOrCreateUser(Payload payload){
    String oauthKey = payload.getSubject();
    return repository.getUserByOauthKey(oauthKey)
        .orElseGet(() -> {
          User user = new User();
          user.setName(payload.getEmail());
          user.setOauthKey(oauthKey);
          return repository.save(user);
        });
  }

}
