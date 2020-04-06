package com.example.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shoppinglist.model.ShopList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onShopItemClickListener {
    private lateinit var shopList: ArrayList<ShopList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shopList = ArrayList()
        addShopItems()

        recycler_view.layoutManager = GridLayoutManager(this, 2)
        recycler_view.adapter = ShoppingListAdapter(shopList, this)

    }


    private fun addShopItems(){
        shopList.add(ShopList("Fashion Shoe", "#5,850", "Lace up Casual Sneakers\nAvailable in Black and Brown",
            R.drawable.shoe))
        shopList.add(ShopList("Analog Watch", "#7,500", "Unique Men's 3ATM\nWater Resistant Luxury Analog Watch",
            R.drawable.digitalwatch))
        shopList.add(ShopList("Polo and Cap", "#3,290", "27 Polo & Cap Bundle\nAvailable in wine and white",
            R.drawable.poloandcap))
        shopList.add(ShopList("Men Fashion Sandals", "#6,500", "Men's Fashion Platform Slippers\nSport Sandal, Available in Grey and Black",
            R.drawable.sandal))
        shopList.add(ShopList("Digital Watch", "#1,800", "Luxury Black full Metal\nDigital Lava Wrist watch-Unisex",
            R.drawable.watch))
        shopList.add(ShopList("Tummy Trimmer", "#1,000", "High Waist Tummy control\nHip shaper slimming brief's back",
            R.drawable.tummytrimmer))
    }

    override fun onItemClick(items: ShopList, position: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("Item Name", items.name)
        intent.putExtra("Item Price", items.price)
        intent.putExtra("Item Desc", items.description)
        intent.putExtra("Item Image", items.image.toString())
        startActivity(intent)
    }
}
