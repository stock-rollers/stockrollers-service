package edu.cnm.deepdive.stockrollersservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@SpringBootApplication
public class StockrollersServiceApplication extends ResourceServerConfigurerAdapter {

  @Value("762642106208-j8u4sq75j3nnjdvt4i6ckmajh18tm7rh.apps.googleusercontent.com")
  private long clientId;


  public static void main(String[] args) {
    SpringApplication.run(StockrollersServiceApplication.class, args);
  }



  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests().anyRequest().anonymous();
    //http.authorizeRequests().anyRequest().hasRole("USER");
  }

}
