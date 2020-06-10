package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView txtResponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
        txtResponse = findViewById(R.id.response_txt_id);
        // to post
            Post post = new Post(5 , "coding with Mokhtar " , "Hi , This is mine and first post  ");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiInterface apiInterface = retrofit.create(ApiInterface.class);
            /// this code in get api
           /* Call<List<Post>> call = apiInterface.getPost( "1");
            call.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    txtResponse.setText(response.body().get(5).getTitle());
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {
                    txtResponse.setText(t.getMessage());
                }
            }); */
           ///////// this code in post api
          //  Call<Post> call = apiInterface.storePost(post);
            HashMap<Object , Object> map = new HashMap<>();
            map.put("title" , " Mostafa Mokhtar ");
            map.put("body" ," this is the second post " ) ;
            map.put("userId", 6) ;
            Call<Post> call = apiInterface.storePost(map);
            call.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                    txtResponse.setText(response.body().getTitle());
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {
                    txtResponse.setText(t.getMessage());
                }
            });
        } // end try
        catch (Exception e){
            txtResponse.setText(e.getLocalizedMessage());
            Toast.makeText(getApplicationContext() , e.getLocalizedMessage() , Toast.LENGTH_LONG).show();
        }

    } // end onCreate()
} // end class
