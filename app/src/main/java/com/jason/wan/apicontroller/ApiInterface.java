package com.jason.wan.apicontroller;

import com.jason.wan.jsonclass.SignInClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("userHandler/signIn.php")
    Call<SignInClass> signIn(
            @Query("email_user") String email_user,
            @Query("pass_user") String pass_user
    );

}
