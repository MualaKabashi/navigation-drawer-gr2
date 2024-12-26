package com.cacttus.navigationdrawergr_2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.cacttus.navigationdrawergr_2.R
import com.cacttus.navigationdrawergr_2.model.Post

class PostAdapter(var context: Context, var posts: List<Post>) : BaseAdapter() {
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return posts.size
    }

    override fun getItem(p0: Int): Any {
        return posts[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var rowView = layoutInflater.inflate(R.layout.post_item, p2, false)

        var postId = rowView.findViewById<TextView>(R.id.postId)
        var title = rowView.findViewById<TextView>(R.id.title)
        var userId = rowView.findViewById<TextView>(R.id.userId)
        var body = rowView.findViewById<TextView>(R.id.body)

        postId.text = posts[p0].id.toString()
        title.text = posts[p0].title
        userId.text = posts[p0].userId.toString()
        body.text = posts[p0].body

        return rowView
    }
}