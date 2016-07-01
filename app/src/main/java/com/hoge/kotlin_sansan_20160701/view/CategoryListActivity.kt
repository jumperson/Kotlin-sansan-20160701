package com.hoge.kotlin_sansan_20160701.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.hoge.kotlin_sansan_20160701.R
import com.hoge.kotlin_sansan_20160701.view.CategoryListRecyclerViewAdapter
import com.hoge.kotlin_sansan_20160701.viewmodel.CategoryListViewModel

class CategoryListActivity : AppCompatActivity() {

    private val viewModel = CategoryListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        val r = findViewById(R.id.recyclerView) as RecyclerView

        r.adapter = CategoryListRecyclerViewAdapter(viewModel.listItems)
    }
}
