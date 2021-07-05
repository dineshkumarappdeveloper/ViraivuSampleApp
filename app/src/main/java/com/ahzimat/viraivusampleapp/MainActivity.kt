package com.ahzimat.viraivusampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.ahzimat.viraivuadapters.ViraivuRecyclerAdapter
import com.ahzimat.viraivuadapters.ViraivuViewHolder
import com.ahzimat.viraivusampleapp.databinding.ItemSampleBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ViraivuRecyclerAdapter{
            ViraivuViewHolder<Any>(ItemSampleBinding.inflate(layoutInflater,it,false))
        }

        val studentList = listOf(
            SampleData("Raja","1st std"),
            SampleData("Mani","1st std"),
            SampleData("Shankar","1st std"),
            SampleData("Remo","1st std")

        )

        adapter.items = studentList

        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter


    }
}