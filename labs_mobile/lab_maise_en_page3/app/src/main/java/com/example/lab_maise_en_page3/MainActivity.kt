package com.example.lab_maise_en_page3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_maise_en_page3.data.TaskRepository
import com.example.lab_maise_en_page3.databinding.ActivityMainBinding
import com.example.lab_maise_en_page3.ui.TaskAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            val taskAdapter = TaskAdapter()
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter = taskAdapter
            floatingActionButton.setOnClickListener {
                val repository= TaskRepository()
                val newTask=repository.newTask()
                newTask.title="New task"+ Random.nextInt()
                repository.save(newTask)
                Toast.makeText(applicationContext,"add task", Toast.LENGTH_LONG).show()
                taskAdapter.notifyDataSetChanged()
            }
        }
    }
}