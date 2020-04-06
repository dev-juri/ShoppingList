package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        itemName.text = getIntent().getStringExtra("Item Name")
        itemPrice.text = getIntent().getStringExtra("Item Price")
        itemDesc.text = getIntent().getStringExtra("Item Desc")
        itemImage.setImageResource(getIntent().getStringExtra("Item Image").toInt())
    }
}
