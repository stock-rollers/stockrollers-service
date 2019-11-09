package edu.cnm.deepdive.stockrollersservice.model.dao;

import edu.cnm.deepdive.stockrollersservice.model.entity.DataPoint;
import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Long> {

  List<History> getHistoriesByStock2OrderByCloseAsc(Stock stock);

}
