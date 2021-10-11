package org.techtown.kotlinstudy09

import android.view.View

interface OnMovieCommentClickListener {

    fun onItemClick(holder: MovieCommentAdapter.ViewHolder?, view: View?, position: Int)

}