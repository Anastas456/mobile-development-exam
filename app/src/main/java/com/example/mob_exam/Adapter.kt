package com.example.mob_exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mob_exam.databinding.PersonListBinding
import kotlin.reflect.KFunction0

class Adapter(private val list: List<Data>): RecyclerView.Adapter<Adapter.DataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.DataHolder {
        val binding = PersonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.DataHolder, position: Int) {
        val person = list[position]
        holder.bind(person)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DataHolder internal constructor(
        private val binding: PersonListBinding
    ):RecyclerView.ViewHolder(binding.root){

        fun bind(person: Data) = binding.run {
            personName.text =person.name+' '+person.surname
            personPhoto.setImageResource(person.pictureRes)
            personMinInfo.text = person.minimalInfo


        }
    }
}