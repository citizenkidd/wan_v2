package com.jason.wan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.jason.wan.apicontroller.ApiClient;
import com.jason.wan.apicontroller.ApiInterface;
import com.jason.wan.jsonclass.SignInClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Log.d("SignIn", "Tes");
        signIn();
    }

    private void signIn() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<SignInClass> signInClassCall = apiInterface.signIn("clem@user.com","pasuhuk123");
        signInClassCall.enqueue(new Callback<SignInClass>() {
            @Override
            public void onResponse(Call<SignInClass> call, Response<SignInClass> response) {
                Log.d("SignIn", response.toString());
            }

            @Override
            public void onFailure(Call<SignInClass> call, Throwable t) {
                Log.d("SignIn", t.toString());
            }
        });
    }
}
