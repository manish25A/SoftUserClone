package com.bishaljung.softuserclone.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manish.softuserclone.Model.StudentModel
import com.bumptech.glide.Glide
import com.manish.softuserclone.R


class StudentDetailAdapter(
    private val studentdata: List<StudentModel>,
) : RecyclerView.Adapter<StudentDetailAdapter.StudentDetailViewHolder>() {
    private var studentList: MutableList<StudentModel> = studentdata as MutableList<StudentModel>

    inner class StudentDetailViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(StudentModel: StudentModel, index: Int) {

            val imgstudent = view.findViewById<ImageView>(R.id.imgstudent)
            val tvstudentname = view.findViewById<TextView>(R.id.tvstudentname)
            val tvStudentAge = view.findViewById<TextView>(R.id.tvStudentAge)
            val tvstudentLocation = view.findViewById<TextView>(R.id.tvstudentLocation)
            val tvGender = view.findViewById<TextView>(R.id.tvGender)
            val imgDelete = view.findViewById<ImageView>(R.id.imgDelete)

            tvstudentname.text = StudentModel.studentName.toString()
            tvStudentAge.text = StudentModel.studentAge.toString()
            tvstudentLocation.text = StudentModel.studentLocation.toString()
            Glide.with(view.context)
                .load(StudentModel.studentImage.toString())
                .into(imgstudent)
            tvGender.text = StudentModel.sudentGender.toString()
            imgDelete.setOnClickListener {
                deleteStudent(index)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_students, parent, false)
        return StudentDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentDetailViewHolder, position: Int) {
        holder.bind(studentList[position], position)
    }

    fun deleteStudent(index: Int) {
        studentList.removeAt(index)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}
