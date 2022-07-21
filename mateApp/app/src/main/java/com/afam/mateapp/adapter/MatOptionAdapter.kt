package com.afam.mateapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afam.mateapp.MatOption
import com.afam.mateapp.MatOptionProvider.Companion.matOptionList
import com.afam.mateapp.R

class MatOptionAdapter(
    private val matOption: List<MatOption>,
    private val onClickListener: (MatOption) -> Unit
) : RecyclerView.Adapter<MatOptionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatOptionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MatOptionViewHolder(layoutInflater.inflate(R.layout.item_matoption, parent, false))
    }

    override fun onBindViewHolder(holder: MatOptionViewHolder, position: Int) {
        val item = matOptionList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = matOption.size
}