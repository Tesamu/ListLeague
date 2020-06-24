package com.example.listleague

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.listleague.Const.PARCELABLE_ITEM_DATA
import com.example.listleague.Const.idImage
import com.example.listleague.Const.idName
import com.example.listleague.Const.idView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DescActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<LeagueData>(PARCELABLE_ITEM_DATA)
        DescActivityUI(item).setContentView(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private class DescActivityUI(val item: LeagueData) : AnkoComponent<DescActivity> {

        override fun createView(ui: AnkoContext<DescActivity>) = with(ui) {
            relativeLayout {
                lparams(wrapContent, wrapContent)

                view {
                    id = idView
                    setBackgroundColor(Color.rgb(128, 128, 128))
                }.lparams(matchParent, dip(150))

                imageView {
                    id = idImage
                    item.image?.let {
                        Picasso.get()
                            .load(it)
                            .into(this)
                    }
                }.lparams(dip(100), dip(100)) {
                    centerHorizontally()
                    topMargin = dip(100)
                }

                textView {
                    id = idName
                    text = item.name
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams {
                    below(idImage)
                    centerHorizontally()
                }

                scrollView {
                    textView {
                        padding = dip(16)
                        text = item.desc
                    }
                }.lparams(matchParent, wrapContent) {
                    below(idName)
                }
            }
        }

    }
}
