package com.example.listleague.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.listleague.model.LeagueData
import com.example.listleague.LeagueUI
import com.example.listleague.utils.Const.ivLeagueID
import com.example.listleague.utils.Const.tvLeagueId
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(private val items: List<LeagueData>, private val listener: (LeagueData) -> Unit) : RecyclerView.Adapter<LeagueAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LeagueUI()
                .createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var ivLeague: ImageView
        private var tvLeague: TextView

        init {
            ivLeague = view.findViewById(ivLeagueID)
            tvLeague = view.findViewById(tvLeagueId)
        }

        fun bindItem(items: LeagueData, listener: (LeagueData) -> Unit) {
            tvLeague.text = items.name
            items.image?.let { Picasso.get().load(it).into(ivLeague) }
            itemView.setOnClickListener { listener(items) }
        }

    }
}