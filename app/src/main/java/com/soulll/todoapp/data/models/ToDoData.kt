package com.soulll.todoapp.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.soulll.todoapp.data.models.Priority
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class ToDoData(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var title: String,
        var priority: Priority,
        var description: String
):Parcelable