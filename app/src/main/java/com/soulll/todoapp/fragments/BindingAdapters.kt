package com.soulll.todoapp.fragments

import android.graphics.Color.red
import android.view.View
import android.widget.Spinner
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.soulll.todoapp.R
import com.soulll.todoapp.R.*
import com.soulll.todoapp.data.models.Priority
import com.soulll.todoapp.data.models.ToDoData
import com.soulll.todoapp.fragments.list.ListFragmentDirections

class BindingAdapters {

    companion object{
        @BindingAdapter("android:navigateToAddFragment")
        @JvmStatic
        fun navigateToAddFragment(view: FloatingActionButton, navigate: Boolean){
            view.setOnClickListener{
                if (navigate) {
                    view.findNavController().navigate(id.action_listFragment_to_addFragment)
                }
            }
        }

        @BindingAdapter("android:emptyDatabase")
        @JvmStatic
        fun emptyDatabase(view: View,emptyDatabase: MutableLiveData<Boolean>){
            when(emptyDatabase.value){
                true -> view.visibility = View.VISIBLE
                false -> view.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("android:parsePriorityToInt")
        @JvmStatic
        fun parsePriorityToInt(view: Spinner, priority: Priority) {
            when(priority) {
                Priority.HIGH -> { view.setSelection(0) }
                Priority.MEDIUM -> { view.setSelection(1) }
                Priority.LOW -> { view.setSelection(2) }
            }
        }

        @BindingAdapter("android:parsePriorityColor")
        @JvmStatic
        fun parsePriorityColor(cardView: CardView, priority: Priority){
            when(priority) {
                Priority.HIGH -> { cardView.setCardBackgroundColor(cardView.context.getColor(R.color.red_500)) }
                Priority.MEDIUM -> { cardView.setCardBackgroundColor(cardView.context.getColor(R.color.yellow_500)) }
                Priority.LOW -> { cardView.setCardBackgroundColor(cardView.context.getColor(R.color.green_500)) }
            }
        }

        @BindingAdapter("android:sendDataToUpdateFragment")
        @JvmStatic
        fun sendDataToUpdateFragment(view: ConstraintLayout, currentItem: ToDoData){
            view.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
                view.findNavController().navigate(action)
            }
        }

    }

}