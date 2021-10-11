package org.techtown.sungshin3f

import android.view.View

interface OnTheaterItemClickListener {

    fun onItemClick(holder: TheaterAdapter.ViewHolder?, view: View?, position: Int)

}