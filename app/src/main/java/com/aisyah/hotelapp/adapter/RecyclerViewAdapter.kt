package com.aisyah.hotelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aisyah.hotelapp.R
import com.aisyah.hotelapp.model.Model
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_list.view.*

class RecyclerViewAdapter(private val listener:(Model)-> Unit): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    private val listHotels=ArrayList<Model>()

    fun setData(items:ArrayList<Model>) {
        listHotels.clear()
        listHotels.addAll(items)
        //buat ngereload/syncronize data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_list, parent, false)
        return RecyclerViewHolder(view)
    }


    override fun getItemCount(): Int = listHotels.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(listHotels[position], listener)
    }


    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(recyclerViewModel: Model, listener: (Model) -> Unit) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(recyclerViewModel.image)
                    .apply (
                        RequestOptions()
                        .override(300))
                    .into(iv_popular)

                tv_name_restaurant.text = recyclerViewModel.title
                tv_address.text = recyclerViewModel.desc

                itemView.setOnClickListener { listener(recyclerViewModel) }

            }

        }

    }
}