package com.example.lab_maise_en_page3.ui

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_maise_en_page3.R
import com.example.lab_maise_en_page3.data.TaskRepository

class TaskAdapter():RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val taskRepository= TaskRepository()
    class TaskViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val taskTitle: TextView = view.findViewById<Button>(R.id.taskTitle)
        val taskPriority: TextView = view.findViewById<Button>(R.id.taskPriority)
        val taskTimestamp: TextView = view.findViewById<Button>(R.id.taskTimestamp)
        val cardView: CardView = view.findViewById(R.id.cardview)
        val list_String:Array<String> =view.resources.getStringArray(R.array.priorities)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layout=
            LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(layout)
    }
    override fun onBindViewHolder(taskViewHolder: TaskViewHolder, position: Int) {

        val task = this.taskRepository.getAllTasks()[position]
        taskViewHolder.taskTitle.text = task.title
        if (task.priority==0){
            taskViewHolder.taskPriority.text=taskViewHolder.list_String[0]
        }else if (task.priority==1){
            taskViewHolder.taskPriority.text=taskViewHolder.list_String[1]
        }else if (task.priority==2){
            taskViewHolder.taskPriority.text=taskViewHolder.list_String[2]
        }
        val format= SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        taskViewHolder.taskTimestamp.text=format.format(task.timestamp)
        taskViewHolder.cardView.setOnClickListener{
            task.title=task.title + "+"
            val repository = TaskRepository()
            repository.save(task)
            this.notifyDataSetChanged()
         println("task updated ")
            for(item in repository.getAllTasks()){
                println(item)
            }
        }
//        taskViewHolder.taskPriority.text = task.priority.toString()
//        taskViewHolder.taskTimestamp.text = task.timestamp.toString()
//        taskViewHolder.cardView.setOnClickListener {
//            task.title = task.title + "+"
//            val repository = TaskRepository()
//            repository.save(task)
//            this.notifyDataSetChanged()
//        }
   }

    override fun getItemCount(): Int {
        return taskRepository.getAllTasks().size
    }
}