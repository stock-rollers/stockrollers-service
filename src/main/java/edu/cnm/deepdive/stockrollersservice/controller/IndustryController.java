package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.IndustryRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.Industry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/industries")
public class IndustryController {

  private final IndustryRepository industryRepository;

  @Autowired
  public IndustryController(IndustryRepository industryRepository) {
    this.industryRepository = industryRepository;
  }

 @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Industry> get(Industry industry) {
    return industryRepository.getAllOrOrderByName(industry);
 }

 //TODO postmapping for getting industry input and then the associated stocks.
}
