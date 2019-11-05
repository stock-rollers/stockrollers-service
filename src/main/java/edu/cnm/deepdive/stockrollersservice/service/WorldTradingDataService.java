package edu.cnm.deepdive.stockrollersservice.service;

import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import io.reactivex.Single;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface WorldTradingDataService {

  static WorldTradingDataService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @GET("stock/")
  Single<Stock> getStock(@Header("api_token") String token, @Query("symbol") String symbol);

  @GET("stock/")
  List<Stock> getStocks(@Header("api_token") String token, @Query("symbol") String symbol, @Query("symbol_two") String symbolTwo);

  @GET("history/")
  List<History> getHistory(@Header("api_token") String token, @Query("symbol") String symbol);

  class InstanceHolder {

    private static final WorldTradingDataService INSTANCE;

    static {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl("https://api.worldtradingdata.com/api/v1/")
          .client(client) // TODO Leave this out for production.
          .build();
      INSTANCE = retrofit.create(WorldTradingDataService.class);
    }
  }

}
