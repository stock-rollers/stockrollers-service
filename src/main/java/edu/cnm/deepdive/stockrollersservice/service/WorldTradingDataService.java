package edu.cnm.deepdive.stockrollersservice.service;

import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.pojo.StockResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorldTradingDataService {

  RestTemplate restTemplate = new RestTemplateBuilder().build();

//  static WorldTradingDataService getInstance() {
//    return InstanceHolder.INSTANCE;
//  }

  public Stock getPostsPlainJSON(String token, String symbol) {
    try {
      Map<String, String> params = new HashMap<>();
      params.put("token", token);
      params.put("symbol", symbol);
      String url = "https://api.worldtradingdata.com/api/v1/stock?api_token={token}&symbol={symbol}";
      StockResponse response = restTemplate.getForObject(url, StockResponse.class, params);
      return response.getData().get(0);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // "http://www.flickr.com/services/rest?method=flickr.photos.search&api+key={api-key}&tags={tag}&per_page=10";
//
//  @GET("stock/")
//  Single<Stock> getStock(@Query("api_token") String token, @Query("symbol") String symbol);
//
//  @GET("history/")
//  List<History> getHistory(@Header("api_token") String token, @Query("symbol") String symbol);

//  class InstanceHolder {
//
//    private static final WorldTradingDataService INSTANCE;
//
//    static {
//      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//      interceptor.setLevel(Level.BODY);
//      OkHttpClient client = new OkHttpClient.Builder()
//          .addInterceptor(interceptor)
//          .build();
//      Retrofit retrofit = new Retrofit.Builder()
//          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//          .addConverterFactory(GsonConverterFactory.create())
//          .baseUrl("https://api.worldtradingdata.com/api/v1/")
//          .client(client) // TODO Leave this out for production.
//          .build();
//      INSTANCE = retrofit.create(WorldTradingDataService.class);
//    }
//  }

}
