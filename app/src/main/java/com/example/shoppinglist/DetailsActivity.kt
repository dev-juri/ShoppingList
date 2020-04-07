package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppinglist.model.ShopList
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    private lateinit var item:ShopList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        item = intent.getSerializableExtra("data") as ShopList

        itemName.text = item.name
        itemPrice.text = item.price
        itemDesc.text = item.description
        itemImage.setImageResource(item.image)

        //itemName.text = getIntent().getStringExtra("Item Name")
        //itemPrice.text = getIntent().getStringExtra("Item Price")
        //itemDesc.text = getIntent().getStringExtra("Item Desc")
        //itemImage.setImageResource(getIntent().getStringExtra("Item Image").toInt())
    }
}
