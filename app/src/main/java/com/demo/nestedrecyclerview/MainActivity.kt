package com.demo.nestedrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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
        var facilityModel = ItemParentModel("Sample 0", ChildDataFactory.getChildren(5))
        listOfFacility.add(facilityModel)

        facilityModel = ItemParentModel("Sample 1", ChildDataFactory.getChildren(5))
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 2", ChildDataFactory.getChildren(5))
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 3", ChildDataFactory.getChildren(5))
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 4", ChildDataFactory.getChildren(5))
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 5", ChildDataFactory.getChildren(5))
        listOfFacility.add(facilityModel)
        facilityModel = ItemParentModel("Sample 6", ChildDataFactory.getChildren(5))
        listOfFacility.add(facilityModel)

        return listOfFacility
    }

    object ChildDataFactory {

        private val random = Random()

        private val titles = arrayListOf("title0", "title1", "title2", "title3", "title4")

        private fun randomTitle(): String {
            val index = random.nextInt(titles.size)
            return titles[index]
        }

        private fun randomImage(): Int {
            return R.drawable.ic_attach_money_128dp
        }

        fun getChildren(count: Int): List<ChildModel> {
            val children = mutableListOf<ChildModel>()
            repeat(count) {
                val child = ChildModel(randomImage(), randomTitle())
                children.add(child)
            }
            return children
        }


    }
}
