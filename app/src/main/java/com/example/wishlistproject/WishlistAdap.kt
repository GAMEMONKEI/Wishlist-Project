package com.example.wishlistproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView

class WishlistAdap(private val wishlist: List<WishlistItem>) : RecyclerView.Adapter<WishlistAdap.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemname: TextView
        val price: TextView
        val url_link: TextView


        init{
            itemname = itemView.findViewById<TextView>(R.id.w_itemname)
            price = itemView.findViewById<TextView>(R.id.w_price)
            url_link = itemView.findViewById<TextView>(R.id.w_url)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishlistview = inflater.inflate(R.layout.wishlistitem, parent, false)
        return ViewHolder(wishlistview)
    }

    override fun getItemCount(): Int {
        return wishlist.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = wishlist.get(position)
        holder.itemname.text = item.name
        holder.price.text = item.price
        holder.url_link.text = item.url
    }
}