package com.moringaschool.cookie.network;

import com.moringaschool.cookie.models.MyEdamamRecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdamamApi {
    @GET("api/recipes/v2")
    Call<MyEdamamRecipeSearchResponse> getRecipes (
            @Query("app_id") String app_id,
            @Query("app_key") String app_key,
            @Query("type") String type,
            @Query("q") String q
    );
}
