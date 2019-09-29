package com.example.zpoc.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zpoc.App
import com.example.zpoc.R
import com.example.zpoc.domain.model.Post
import com.example.zpoc.presentation.base.Constant
import com.example.zpoc.presentation.detail.DetailActivity
import com.example.zpoc.presentation.home.adapter.PostListAdapter
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), HomeActivityMVP.View {

    @Inject
    lateinit var constants: Constant


    @Inject
    lateinit var presenter: HomeActivityMVP.Presenter

    private var adapterData = mutableListOf<Post>()

    var adapterPost = PostListAdapter(adapterData) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(constants.POST_ID_KEY, it.id)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getPost()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        App.instance.getApplicationGetComponent().inject(this)
        adapterPost = PostListAdapter(adapterData) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(constants.POST_ID_KEY, it.id)
            startActivity(intent)
        }
        val linearLayoutManager = LinearLayoutManager(this)
        list.apply {
            layoutManager = linearLayoutManager
            adapter = adapterPost
            addItemDecoration(DividerItemDecoration(this.context, linearLayoutManager.orientation))
        }

        delete_button.setOnClickListener {
            presenter.deleteAllPost()
        }
    }

    override fun notifyPostChanged(post: List<Post>) {
       no_text_found.visibility = View.GONE
        list.visibility = View.VISIBLE
        adapterData.clear()
        adapterData.addAll(post)
        adapterPost.notifyDataSetChanged()
    }

    override fun notifyNoPostFound() {
        no_text_found.visibility = View.VISIBLE
        list.visibility = View.GONE
        adapterData.clear()
        adapterPost.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sync_button -> presenter.updateData()
        }
        return true
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
