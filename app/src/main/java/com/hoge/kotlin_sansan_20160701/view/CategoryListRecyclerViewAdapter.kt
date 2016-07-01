package com.hoge.kotlin_sansan_20160701.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hoge.kotlin_sansan_20160701.databinding.CaptionItemBinding
import com.hoge.kotlin_sansan_20160701.databinding.CategoryItemBinding
import com.hoge.kotlin_sansan_20160701.databinding.SubCaptionItemBinding
import com.hoge.kotlin_sansan_20160701.viewmodel.CategoryListViewModel


/**
 * Created by okamoto_kazuya on 16/07/01.
 */

class CategoryListRecyclerViewAdapter(private var items: List<CategoryListViewModel.ListItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        parent ?: return null

        val itemType = CategoryListViewModel.ListItem.Type.from(viewType)
        when (itemType) {
            CategoryListViewModel.ListItem.Type.Caption -> {
                val binding = CaptionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CaptionItemViewHolder(binding)
            }

            CategoryListViewModel.ListItem.Type.SubCaption -> {
                val binding = SubCaptionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return SubCaptionItemViewHolder(binding)
            }

            CategoryListViewModel.ListItem.Type.Category -> {
                val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CategoryItemViewHolder(binding)
            }

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val item = items[position]

        when {
            holder is CaptionItemViewHolder && item is CategoryListViewModel.ListItem.CaptionItem -> {
                @Suppress("MISSING_DEPENDENCY_CLASS")
                holder.binding.item = item
            }

            holder is SubCaptionItemViewHolder && item is CategoryListViewModel.ListItem.SubCaptionItem -> {
                @Suppress("MISSING_DEPENDENCY_CLASS")
                holder.binding.item = item
            }

            holder is CategoryItemViewHolder && item is CategoryListViewModel.ListItem.CategoyItem -> {
                @Suppress("MISSING_DEPENDENCY_CLASS")
                holder.binding.item = item
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return item.getType().id
    }

    override fun getItemCount() = items.count()

    private class CaptionItemViewHolder(val binding: CaptionItemBinding): RecyclerView.ViewHolder(binding.root) { }
    private class SubCaptionItemViewHolder(val binding: SubCaptionItemBinding): RecyclerView.ViewHolder(binding.root) { }
    private class CategoryItemViewHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root) { }
}