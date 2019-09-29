package com.example.zpoc.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zpoc.App
import com.example.zpoc.Constants
import com.example.zpoc.R
import com.example.zpoc.domain.model.Comment
import com.example.zpoc.domain.model.Post
import com.example.zpoc.domain.model.User
import com.example.zpoc.presentation.base.Constant
import com.example.zpoc.presentation.detail.adapter.CommentsAdapter
import com.example.zpoc.presentation.detail.util.Util
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailActivityMVP.View {

    @Inject
    lateinit var util: Util

    @Inject
    lateinit var presenter: DetailActivityMVP.Presenter

    @Inject
    lateinit var constants: Constant

    var postId = 0

    private val adapterCommentData = mutableListOf<Comment>()
    private val adapterComments = CommentsAdapter(adapterCommentData)

    override fun updatePostInfo(post: Post) {
        body.text = post.body
        presenter.makePostAlreadySeen(post)
    }

    override fun updateComments(comments: List<Comment>) {
        adapterCommentData.clear()
        adapterCommentData.addAll(comments)
        adapterComments.notifyDataSetChanged()
    }

    override fun updateUserInfo(user: User) {
        user_info.text = util.formatUserIntoLabelStrning(user)
    }


    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        App.instance.getApplicationGetComponent().inject(this)
        postId = intent.extras[constants.POST_ID_KEY] as Int
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter.setView(this)
        list.apply {
            val linearLayoutManager = LinearLayoutManager(this@DetailActivity)
            layoutManager = linearLayoutManager
            adapter = adapterComments
            addItemDecoration(DividerItemDecoration(this.context, linearLayoutManager.orientation))
        }

        presenter.getData(postId)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.fa_button -> presenter.makePostFavorite()
            android.R.id.home -> onBackPressed()
        }
        return true
    }
}
