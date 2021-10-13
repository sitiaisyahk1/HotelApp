package com.aisyah.hotelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aisyah.hotelapp.R
import com.aisyah.hotelapp.model.Model
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_popular_hotel.view.*
import kotlinx.android.synthetic.main.item_staggered_row.view.*

class StaggeredAdapter(private val listStaggered:ArrayList<Model>) : RecyclerView.Adapter<StaggeredAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            //knp false? karna attach to root value
            .inflate(R.layout.item_staggered_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: Model) {
            with(itemView) {
                Glide.with(itemView)
                    .load(model.image)
                    .apply(RequestOptions().override(400))
                    .into(iv_staggered_hotel)

                tv_staggered_name_hotel.text = model.title
                tv_staggered_desc2_hotel.text = model.desc
                tv_staggered_address2_hotel.text = model.address
                txtprice.text = model.price


            }
        }


    }
}