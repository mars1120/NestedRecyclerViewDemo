package com.demo.nestedrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = rv_base
        recyclerView.apply {
            adapter = HomeItemParentAdapter(getParents())
        }
    }
    private fun getParents(): List<ItemParentModel> {
        val listOfFacility = mutableListOf<ItemParentModel>()
        var facilityModel = ItemParentModel("Sample 0")
        listOfFacility.add(facilityModel)

        facilityModel = ItemParentModel("Sample 1")
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 2")
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 3")
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 4")
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 5")
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 6")
        listOfFacility.add(facilityModel)

        return listOfFacility
    }
}
