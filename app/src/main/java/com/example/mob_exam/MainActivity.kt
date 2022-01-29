package com.example.mob_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mob_exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val verticalLinearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecycleView()
    }

    private fun setRecycleView(){
        binding.personList.layoutManager = verticalLinearLayoutManager
        binding.personList.adapter = Adapter(DataHolder.createList())
    }

    private fun toNextPage(person: Data){
        val fragment = SecondPage()
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_page, fragment)
        transaction.commit()
    }
}