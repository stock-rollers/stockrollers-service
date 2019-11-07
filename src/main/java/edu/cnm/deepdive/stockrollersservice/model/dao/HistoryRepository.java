package edu.cnm.deepdive.stockrollersservice.model.dao;

import edu.cnm.deepdive.stockrollersservice.model.entity.DataPoint;
import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Long> {

  List<DataPoint> getDataPointsByStockId(long stockId);

}
