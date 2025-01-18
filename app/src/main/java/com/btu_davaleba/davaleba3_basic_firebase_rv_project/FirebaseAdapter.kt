package com.btu_davaleba.davaleba3_basic_firebase_rv_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.btu_davaleba.davaleba3_basic_firebase_rv_project.data.FirebasePost
import java.util.Random


class FirebaseAdapter(val list: List<FirebasePost>): RecyclerView.Adapter<FirebaseAdapter.ViewHolder>() {



    private val random = Random()
    // Firebaseze payment plan shecvales da agar davamate fotoebi iq, amitom randomze vurchev tito posts fotos
    private val catImages = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_5,
        R.drawable.cat_6,
        R.drawable.cat_7,
        R.drawable.cat_8
    )

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.item_image)
        val userName: TextView = itemView.findViewById(R.id.item_tv_username)
        val description: TextView = itemView.findViewById(R.id.item_tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        holder.userName.text = currentItem.userName
        holder.description.text = currentItem.description

        val randomImageRes = catImages[random.nextInt(catImages.size)]
        holder.image.setImageResource(randomImageRes)
    }

}