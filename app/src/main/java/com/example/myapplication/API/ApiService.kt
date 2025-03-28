package com.example.myapplication.API

import com.example.myapplication.DataClass.JobResponse
import com.example.myapplication.Model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("job-board-api")
    fun searchJobs(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("visa_sponsorship") visaSponsorship: Boolean? = null
    ): Call<JobResponse>
    @FormUrlEncoded
    @POST("login.php")
    fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
    @FormUrlEncoded
    @POST("register.php")
    fun registerUser(
        @Field("fullname") fullname: String,
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}