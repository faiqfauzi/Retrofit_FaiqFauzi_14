package com.example.Retrofit_FaiqFauzi_14.api

import com.example.Retrofit_FaiqFauzi_14.model.IndonesiaResponse
import com.example.Retrofit_FaiqFauzi_14.model.ProvinceResponse
import retrofit2.http.GET

interface Api{
    @GET ("casenumber.json")
    fun getIndonesia(): retrofit2.Call<ArrayList<IndonesiaResponse>>

    @GET ("casenumberprovince.json")
    fun getProvince(): retrofit2.Call<ArrayList<ProvinceResponse>>
}
