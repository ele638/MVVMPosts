package com.example.mvvmposts.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmposts.ui.post.PostListAdapter
import com.example.mvvmposts.utils.extensions.getParentActivity

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>){
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null){
        text.observe(parentActivity, Observer { value -> view.text = value?:"" })
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: PostListAdapter){
    view.adapter = adapter
}