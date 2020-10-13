package com.example.mylistview

import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mylistview.Apparel
import com.example.mylistview.R
import values.ApparelAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ApparelAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var apparel = arrayListOf<Apparel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)

        adapter = ApparelAdapter(this)

        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, apparel[position].name, Toast.LENGTH_SHORT)
                .show()
        }

    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val apprl = Apparel(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            apparel.add(apprl)
        }
        adapter.apparel = apparel
    }
}