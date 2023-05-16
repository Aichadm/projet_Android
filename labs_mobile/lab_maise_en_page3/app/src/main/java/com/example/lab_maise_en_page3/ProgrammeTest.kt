package com.example.lab_maise_en_page3

import com.example.lab_maise_en_page3.data.TaskEntry
import com.example.lab_maise_en_page3.data.TaskRepository

fun main() {
    print("Programme de Test")
    val taskRepository= TaskRepository()
    /// Add task
    val task = TaskEntry(1,"Task 1",1,System.currentTimeMillis())
    val task2 = TaskEntry(1,"Task 2",1,System.currentTimeMillis())
    taskRepository.save(task)
    taskRepository.save(task2)
    print(task)
    print(task2)
    // Delete task
       taskRepository.delete(3)
   //Edit task
    val updateTask=taskRepository.findById(4)
    updateTask.title="Task_edit"
        // taskRepository.save(updateTask)
    //view tasks
    for (item in taskRepository.getAllTasks()){
        println(item.title)
    }




}