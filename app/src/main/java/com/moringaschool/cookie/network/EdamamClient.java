package com.moringaschool.cookie.network;

import static com.moringaschool.cookie.Constants.EDAMAM_BASE_URL;

//import com.itkacher.okprofiler.BuildConfig;
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor;
import com.moringaschool.cookie.BuildConfig;
import com.moringaschool.cookie.network.EdamamApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EdamamClient {
    private  static Retrofit retrofit = null;

    public  static EdamamApi getClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new OkHttpProfilerInterceptor());
        }
        OkHttpClient client = builder.build();

//        if (retrofit == null){
//            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request newRequest = chain.request().newBuilder()
//                                    .build();
//                            return chain.proceed(newRequest);
//                        }
//                    })
//                    .build();


            retrofit = new Retrofit.Builder()
                    .baseUrl(EDAMAM_BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
//        }
        return  retrofit.create(EdamamApi.class);
    }
}
