package com.example.teachme.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.data.models.LessonPM
import com.example.teachme.ui.layouts.LessonItemLayout

class LessonAdapter(
    val context: Context,
    private val listener: LessonItemLayout.OnClickListener
) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    val diffCallback = object : DiffUtil.ItemCallback<LessonPM>() {
        override fun areItemsTheSame(oldItem: LessonPM, newItem: LessonPM): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.title == newItem.title &&
                    oldItem.startDate == newItem.startDate &&
                    oldItem.selectedDays == newItem.selectedDays &&
                    oldItem.startTime == newItem.startTime &&
                    oldItem.endTime == newItem.endTime &&
                    oldItem.rate == newItem.rate &&
                    oldItem.note == newItem.note &&
                    oldItem.students == newItem.students &&
                    oldItem.autogenerateLessons == newItem.autogenerateLessons
        }

        override fun areContentsTheSame(oldItem: LessonPM, newItem: LessonPM): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(LessonItemLayout(context, listener))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val currentLesson = differ.currentList[position]
        holder.layout.fillContent(currentLesson)
    }

    fun setData(lessons: List<LessonPM>) = differ.submitList(lessons)

    inner class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView as LessonItemLayout
    }
}
