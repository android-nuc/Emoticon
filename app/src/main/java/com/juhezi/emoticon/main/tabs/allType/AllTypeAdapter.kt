package com.juhezi.emoticon.main.tabs.allType

import android.support.design.widget.NavigationView
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juhezi.emoticon.R
import com.juhezi.emoticon.model.TypeMenu
import java.util.*

/**
 * Created by qiao1 on 2016/11/25.
 */
class AllTypeAdapter : RecyclerView.Adapter<AllTypeAdapter.ViewHolder>() {

    private var TAG = "AllTypeAdapter"

    var typeMenus = ArrayList<TypeMenu>()
        set(value) {
            typeMenus.clear()
            typeMenus.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_all_type, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mNav?.menu?.clear()
        holder.mNav?.inflateMenu(typeMenus[position].resId)

    }

    override fun getItemCount(): Int {
        return typeMenus.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mNav: NavigationView? = null
        var mCardView: CardView? = null

        init {
            mNav = itemView.findViewById(R.id.nav_item_all_type) as NavigationView
            mCardView = itemView.findViewById(R.id.cv_item_all_type) as CardView
        }

    }

}