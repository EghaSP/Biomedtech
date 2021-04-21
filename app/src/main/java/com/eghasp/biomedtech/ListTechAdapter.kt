package com.eghasp.biomedtech

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import com.bumptech.glide.request.RequestOptions


class ListTechAdapter(val listTech: ArrayList<tech>) : RecyclerView.Adapter<ListTechAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_tech, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val techs = listTech[position]
        Glide.with(holder.itemView.context)
                .load(techs.photo)
                .apply(RequestOptions().override(200, 200))
                .into(holder.imgPhoto)
        holder.tvName.text = techs.name
        holder.tvDetail.text = techs.detail
        holder.itemView.setOnClickListener (object :View.OnClickListener{
            override fun onClick(view: View) {
                onItemClickCallback.onItemClicked(listTech[holder.adapterPosition])

                val pindah = Intent(view.context.applicationContext, DetailActivity::class.java)
                pindah.putExtra(DetailActivity.EXTRA_NAME, techs.name)
                pindah.putExtra(DetailActivity.EXTRA_DETAIL, techs.detail)
                pindah.putExtra(DetailActivity.EXTRA_PHOTO, techs.photo)

                view.context.startActivity(pindah)
            }
        })

    }


    override fun getItemCount(): Int {
        return listTech.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: tech)
    }
}
