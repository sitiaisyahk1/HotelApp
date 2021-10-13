package com.aisyah.hotelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aisyah.hotelapp.model.Model
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_popular_hotel.*

class DetailPopularHotelActivity : AppCompatActivity() {

    companion object {
        const val KEY_POPULAR_HOTEL = "key_popular_hotel"
    }

    private var model: Model? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_popular_hotel)
        model = intent.getParcelableExtra(KEY_POPULAR_HOTEL)



        lable_name.text = model?.title
        lable_desc.text = model?.desc
        lable_address.text = model?.address
        txtprice.text = model?.price
        Glide.with(this).load(model?.image).apply(RequestOptions()).override(500)
            .into(iv_image_detail_popular)

        showBackHome()
    }

    private fun showBackHome() {
        iv_backstage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}