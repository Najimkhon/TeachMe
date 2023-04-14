package com.example.teachme.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.data.models.StudentPM
import com.example.teachme.ui.layouts.StudentItemLayout

class StudentAdapter(
    val context: Context
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    val diffCallback = object : DiffUtil.ItemCallback<StudentPM>() {
        override fun areItemsTheSame(oldItem: StudentPM, newItem: StudentPM): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.fullName == newItem.fullName &&
                    oldItem.address == newItem.address &&
                    oldItem.telegram == newItem.telegram &&
                    oldItem.phone == newItem.phone &&
                    oldItem.payment == newItem.payment &&
                    oldItem.email == newItem.email
        }

        override fun areContentsTheSame(oldItem: StudentPM, newItem: StudentPM): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(StudentItemLayout(context))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = differ.currentList[position]
        holder.layout.fillContent(currentStudent)
    }

    fun setData(students: List<StudentPM>) = differ.submitList(students)

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView as StudentItemLayout
    }
}
