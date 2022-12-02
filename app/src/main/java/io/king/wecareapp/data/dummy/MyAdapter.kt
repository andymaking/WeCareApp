package io.king.wecareapp.data.dummy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.king.wecareapp.R

class MyAdapter(private val residents: Array<Resdents>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.assigned_residents_item, parent, false)
        return MyViewHolder(itemView,  mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = residents[position]
        holder.residentsName.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return  residents.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        var residentsName: TextView = itemView.findViewById(R.id.residentsName)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}