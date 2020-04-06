package com.example.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.model.ShopList
import kotlinx.android.synthetic.main.layout_shopping_list.view.*

class ShoppingListAdapter(
    var items: List<ShopList> = ArrayList(),
    var clickListener: onShopItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShopViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_shopping_list, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ShopViewHolder -> {
                holder.bind(items.get(position), clickListener)
            }
        }
    }
    override fun getItemCount(): Int = items.size

    fun listGoods(goodsList: List<ShopList>){
        items = goodsList
    }

    class ShopViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemImage = itemView.item_image
        val itemName = itemView.item_name
        val itemPrice = itemView.item_price

        fun bind(goods: ShopList, action: onShopItemClickListener) {
            itemName.text = goods.name
            itemPrice.text = goods.price
            itemImage.setImageResource(goods.image)

            itemView.setOnClickListener {
                action.onItemClick(goods, adapterPosition)
            }
        }

    }

}

interface onShopItemClickListener{
    fun onItemClick(items: ShopList, position: Int)
}