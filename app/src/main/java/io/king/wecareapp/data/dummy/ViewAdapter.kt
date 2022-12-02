package io.king.wecareapp.data.dummy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import io.king.wecareapp.R

class ViewAdapter(private val residents: Array<DropDown>) : RecyclerView.Adapter<ViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.drowdown_ui, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = residents[position]
        holder.comment.text = currentItem.comment
        holder.assesment.text = currentItem.assessment
        holder.title.text = currentItem.title
        holder.shapeableImageView.setImageResource(currentItem.image)

        val isVisible : Boolean = currentItem.visibility
        holder.showVisible.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.constraint.setOnClickListener {
            currentItem.visibility = ! currentItem.visibility
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return  residents.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var comment: TextView = itemView.findViewById(R.id.comment)
        var assesment: TextView = itemView.findViewById(R.id.assesment)
        var shapeableImageView: ShapeableImageView = itemView.findViewById(R.id.shapeableImageView)
        var title: TextView = itemView.findViewById(R.id.title)
        var showVisible: LinearLayout = itemView.findViewById(R.id.showVisible)
        var constraint: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)


    }
}