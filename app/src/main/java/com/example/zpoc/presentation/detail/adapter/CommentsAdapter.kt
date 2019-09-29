package com.example.zpoc.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zpoc.R
import com.example.zpoc.domain.model.Comment
import kotlinx.android.synthetic.main.comment_template.view.*

class CommentsAdapter(val data: List<Comment>) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.comment_template, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(comment: Comment){
            view.comment.text = comment.body
        }
    }
}