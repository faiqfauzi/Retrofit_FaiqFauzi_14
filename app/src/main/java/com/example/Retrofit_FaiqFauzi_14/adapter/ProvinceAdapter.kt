package com.example.Retrofit_FaiqFauzi_14.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Retrofit_FaiqFauzi_14.R
import com.example.Retrofit_FaiqFauzi_14.model.ProvinceResponse

class ProvinceAdapter (private var list: ArrayList<ProvinceResponse>): RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>(){
    inner class ProvinceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(province: ProvinceResponse){
            with(itemView){
                findViewById<TextView?>(R.id.tvName).text = province.attributes.province
                findViewById<TextView?>(R.id.tvPositive).text = province.attributes.positive.toString()
                findViewById<TextView?>(R.id.tvRecover).text = province.attributes.recover.toString()
                findViewById<TextView?>(R.id.tvDeath).text = province.attributes.death.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}