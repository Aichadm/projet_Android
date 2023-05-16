package com.example.lab_kotlin

import com.example.lab_kotlin.data.TaskEntry
import com.example.lab_kotlin.data.TaskRepository
import com.example.lab_kotlin.data.TaskDao
fun main() {
    print("Programme de test ")
    val taskRepository = TaskRepository()
        // add task
    //val task0 = TaskEntry(1,"Task 1",1,null)
    //taskRepository.save(task0)
   // print(task0)
        // test
    //val task = TaskEntry(1,"Task 1",1,null)
    //val task1 = TaskEntry(1,"Task 1",1,null)
    //println(task == task1)
   // println(task.toString())
    // update task
    val updateTask = taskRepository.findById(1)
    updateTask.title = "task n"
    println(updateTask)
    taskRepository.save(updateTask)
     println(updateTask)
    // delete task
    // taskRepository.delete(2)
    // view tasks

    for(item in taskRepository.getAllTasks() ) {
                print(item.title)
    }
}