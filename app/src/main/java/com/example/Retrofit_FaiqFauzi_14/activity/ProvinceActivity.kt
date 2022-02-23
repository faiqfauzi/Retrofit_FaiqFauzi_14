package com.example.Retrofit_FaiqFauzi_14.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Retrofit_FaiqFauzi_14.R
import com.example.Retrofit_FaiqFauzi_14.adapter.ProvinceAdapter
import com.example.Retrofit_FaiqFauzi_14.api.RetrofitClient
import com.example.Retrofit_FaiqFauzi_14.model.ProvinceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        showProvince()

    }

    private fun showProvince() {
        findViewById<RecyclerView>(R.id.rvProvince).setHasFixedSize(true)
        findViewById<RecyclerView>(R.id.rvProvince).layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvince().enqueue(object : Callback<ArrayList<ProvinceResponse>>{
            override fun onResponse(
                call: Call<ArrayList<ProvinceResponse>>,
                response: Response<ArrayList<ProvinceResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                findViewById<RecyclerView>(R.id.rvProvince).adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}