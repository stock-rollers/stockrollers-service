package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.IndustryRepository;
import edu.cnm.deepdive.stockrollersservice.model.dao.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


}
