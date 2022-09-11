package com.example.weather.adapters

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.databinding.ListItemBinding
import com.example.weather.models.WeatherModel

class WeatherAdapter : ListAdapter<WeatherModel, WeatherAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view) { //сохранение шаблона
        val binding = ListItemBinding.bind(view)
        fun bind(item: WeatherModel) = with(binding) {
            tvInfo.text = item.time
            tvConditionItem.text = item.condition
            tvTemp.text = item.currentTemperature
        }
    }

    class Comparator : DiffUtil.ItemCallback<WeatherModel>() {
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean { //сравнение элементов в контейнере
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder { //создание разметки
        val view = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.list_item, parent, false) // загрузка в память
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) { //получение элемента, обновление разметки, заполнение
        holder.bind(getItem(position))
    }
}