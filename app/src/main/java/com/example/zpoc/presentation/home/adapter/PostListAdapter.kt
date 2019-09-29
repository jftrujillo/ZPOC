package com.example.zpoc.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zpoc.R
import com.example.zpoc.domain.model.Post
import kotlinx.android.synthetic.main.post_element_template.view.*

class PostListAdapter (var data: List<Post>, private val clickListener: (Post) -> Unit) : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_element_template, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder (private val view : View) : RecyclerView.ViewHolder(view) {
        fun bind(post: Post, clickListener: (Post) -> Unit) {
            post.apply {
                view.body.text = body
                if (isSeen) view.seen_image.visibility = View.INVISIBLE else view.seen_image.visibility = View.VISIBLE
                if (isFav) view.fav_image.visibility = View.VISIBLE else view.fav_image.visibility = View.INVISIBLE
                view.parent_template.setOnClickListener { clickListener(this) }
            }
        }
    }
}