package com.seoleo96.simplelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "https://www.breakingbadapi.com/";

    ArrayList<Users> usersList = new ArrayList<>();
    UsersRecycleView usersRecycleView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface  = retrofit.create(ApiInterface.class);
        final Call<ArrayList<Users>> userList = apiInterface.getUsers();

        userList.enqueue(new Callback<ArrayList<Users>>() {
            @Override
            public void onResponse(Call<ArrayList<Users>> call, Response<ArrayList<Users>> response) {
                if (!response.isSuccessful()){
                    Log.d(TAG, response.message());
                    return;
                }
                usersList = response.body();
                usersRecycleView = new UsersRecycleView( getApplicationContext(),usersList);

                recyclerView.setAdapter(usersRecycleView);


                for (Users users:usersList   ) {
                    System.out.println(users.getUrlImage());
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Users>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
