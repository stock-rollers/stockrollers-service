package edu.cnm.deepdive.stockrollersservice.model.dao;

import edu.cnm.deepdive.stockrollersservice.model.entity.DataPoint;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DataPointRepository extends CrudRepository<DataPoint, Long> {

  List<DataPoint> getDataPointsByStockOrderByHorizontalAsc(Stock stock);
  //List<DataPoint> getDataPointsByStockIdOrderByHorizontalAsc(Stock stock);

}
