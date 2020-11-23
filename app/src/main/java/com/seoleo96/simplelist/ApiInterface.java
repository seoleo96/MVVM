package com.seoleo96.simplelist;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/characters/")
    Call<ArrayList<Users>> getUsers();
}
