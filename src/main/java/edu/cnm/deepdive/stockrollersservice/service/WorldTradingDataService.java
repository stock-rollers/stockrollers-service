package edu.cnm.deepdive.stockrollersservice.service;

import io.reactivex.Single;
import edu.cnm.deepdive.stockrollersservice.model.Stock;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface WorldTradingDataService {

//  @GET("stockrollers/")
//  Single<Stock> get


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
