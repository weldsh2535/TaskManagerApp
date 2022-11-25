package com.version1.taskmanageapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.version1.taskmanageapp.db.UserEntity
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter(
   val listener :RowClickListener
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = ArrayList<UserEntity>()

    fun setListData(data:ArrayList<UserEntity>){
        this.items = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent,false)
        return MyViewHolder(inflater,listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       holder.itemView.setOnClickListener{
           listener.onItemClickListener(items[position])
       }
      //  holder.bind(items[position])
        holder.bindingAdapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(view: View,val listener: RowClickListener):RecyclerView.ViewHolder(view){
        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val deleteUserID = view.deleteUserID
//        val tvPhone = view.tvPhone
        fun bind(data:UserEntity){
            tvName.text = data.name

            tvEmail.text = data.email


//            tvPhone.text = data.phone

         deleteUserID.setOnClickListener {
               listener.onDeleteUserClickListener(data)
            }
        }
    }
    interface RowClickListener{
        fun onDeleteUserClickListener(user: UserEntity)
        fun onItemClickListener(user: UserEntity)
    }

}