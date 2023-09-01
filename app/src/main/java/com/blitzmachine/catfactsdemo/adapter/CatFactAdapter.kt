package com.blitzmachine.catfactsdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blitzmachine.catfactsdemo.databinding.ItemCatfactBinding
import com.blitzmachine.catfactsdemo.model.CatFact

class CatFactAdapter(private val dataset: List<CatFact>) : RecyclerView.Adapter<CatFactAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(private val binding: ItemCatfactBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CatFact) {
            binding.textView.setText(item.fact)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemCatfactBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataset[position])
    }
}