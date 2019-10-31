package edu.cnm.deepdive.stockrollersservice.dao;

import edu.cnm.deepdive.stockrollersservice.model.DataPoint;
import edu.cnm.deepdive.stockrollersservice.model.Stock;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DataPointRepository extends CrudRepository<DataPoint, Long> {
  List<DataPoint> getDataPointsByStockIdOrderByHorizontalAsc(Stock stock);
}
