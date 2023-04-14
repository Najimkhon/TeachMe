package com.example.teachme.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.data.models.StudentPM
import com.example.teachme.ui.layouts.StudentItemLayout

class StudentAdapter(
    val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var studentList = emptyList<StudentPM>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(StudentItemLayout(context))
        println("ADAPTER WORKS")
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = studentList[position]
        holder.layout.fillContent(currentStudent)
    }

    fun setData(students: List<StudentPM>){
        this.studentList = students
        notifyDataSetChanged()
    }

    inner class StudentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val layout = itemView as StudentItemLayout
    }
}
