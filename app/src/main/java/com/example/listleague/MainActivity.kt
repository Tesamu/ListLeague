package com.example.listleague

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.listleague.Const.PARCELABLE_ITEM_DATA
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<LeagueData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
        MainActivityUI(items).setContentView(this)
    }

    private class MainActivityUI(val items: List<LeagueData>) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams(matchParent, wrapContent)

                recyclerView{
                    layoutManager = GridLayoutManager(context,2)
                    addItemDecoration(LeagueGridList(10, 2))
                    adapter = LeagueAdapter(items) {
                        startActivity<DescActivity>(PARCELABLE_ITEM_DATA to it)
                    }
                }
            }
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.league_name)
        val image = resources.obtainTypedArray(R.array.league_image)
        val desc = resources.getStringArray(R.array.league_desc)
        items.clear()
        for (i in name.indices) {
            items.add(LeagueData(name[i],image.getResourceId(i,0), desc[i]))
        }

        image.recycle()
    }

}
