package com.example.listleague

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.example.listleague.Const.ivLeagueID
import com.example.listleague.Const.tvLeagueId
import org.jetbrains.anko.*

class LeagueUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        verticalLayout {
            padding = dip(16)

            imageView {
                id = ivLeagueID
            }.lparams(width = wrapContent, height = 120.dp){
                gravity = Gravity.CENTER
            }

            textView {
                id = tvLeagueId
            }.lparams(wrapContent, wrapContent){
                gravity = Gravity.CENTER
            }
        }
    }
}