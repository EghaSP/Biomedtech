package com.eghasp.biomedtech

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var rvTech : RecyclerView
    private var list: ArrayList<tech> = arrayListOf()
    private lateinit var listTechAdapter: ListTechAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTech = findViewById(R.id.rv_tech)
        rvTech.setHasFixedSize(true)

        list.addAll(TechData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvTech.layoutManager = LinearLayoutManager(this)
        val listTechAdapter =ListTechAdapter(list)
        rvTech.adapter = listTechAdapter

        listTechAdapter.setOnItemClickCallback(object : ListTechAdapter.OnItemClickCallback {
            override fun onItemClicked(data: tech) {
                showSelectedTech(data)
            }
        })
    }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.about_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_about ->{
                this.startActivity(Intent(this,AboutActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }


    }
    private fun setMode(selectedMode: Int) {
            R.id.action_about
    }

    private fun showSelectedTech(techs : tech) {
    }




}
