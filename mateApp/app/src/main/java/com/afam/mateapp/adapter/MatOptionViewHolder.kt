package com.afam.mateapp.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.afam.mateapp.MatOption
import com.afam.mateapp.databinding.ItemMatoptionBinding

class MatOptionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemMatoptionBinding.bind(view)

    fun render(matOptionModel: MatOption,onClickListener: (MatOption) -> Unit) {
        binding.tvName.text = matOptionModel.name
        binding.tvName.setBackgroundColor(Color.parseColor(matOptionModel.color))
        itemView.setOnClickListener{onClickListener(matOptionModel)}
    }
}