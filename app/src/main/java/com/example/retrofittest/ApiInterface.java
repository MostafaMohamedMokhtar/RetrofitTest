package com.example.retrofittest;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    // using Resources
   /* @GET("posts/2")
    public Call<Post> getPost(); */
   // using Query
    @GET("posts")
    public Call<List<Post>> getPost(@Query("userId") String userId);
    // in the state of using class post
 /*   @POST("posts")
    public Call<Post> storePost(@Body Post post); */
    // in the state of using Map with different objects
    @POST("posts")
    public Call<Post> storePost(@Body HashMap<Object , Object> map);

}
