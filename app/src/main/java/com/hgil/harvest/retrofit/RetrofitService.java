package com.hgil.harvest.retrofit;

import com.hgil.harvest.utils.API;
import com.hgil.harvest.retrofit.loginResponse.loginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by mohan.giri on 04-01-2017.
 */

public interface RetrofitService {
    @GET(API.LOGIN_URL)
    Call<loginResponse> getUserLogin(@Path("username") String username, @Path("password") String password);

    @FormUrlEncoded
    @POST(API.LOGIN_URL)
    Call<loginResponse> postUserLogin(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST(API.LOGIN_URL)
    Call<ResponseBody> testLogin(@Field("username") String username, @Field("password") String password);
}
