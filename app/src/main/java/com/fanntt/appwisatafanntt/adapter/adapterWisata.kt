package com.fanntt.appwisatafanntt.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fanntt.appwisatafanntt.DetailWisata
import com.fanntt.appwisatafanntt.ListWisata
import com.fanntt.appwisatafanntt.R
import com.fanntt.appwisatafanntt.model.modelWisata

class adapterWisata(
    val getdetailWisata : ListWisata,
    val listitemwisata: List<modelWisata>

) : RecyclerView.Adapter<adapterWisata.MyViewHolder>() {
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var ImgWisata : ImageView=itemView.findViewById(R.id.imgWisata)
        var NamaWisata : TextView=itemView.findViewById(R.id.NamaWisata)
        var LokasiWisata : TextView=itemView.findViewById(R.id.LokasiWisata)
        var cardWisata : CardView=itemView.findViewById(R.id.WisataCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitemwisata,parent,false )
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return listitemwisata.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listitemwisata[position]
        holder.ImgWisata.setImageResource(currentItem.ImgWisata)
        holder.NamaWisata.text = currentItem.NamaWisata.toString()
        holder.LokasiWisata.text = currentItem.LokasiWisata.toString()

        holder.cardWisata.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getdetailWisata, DetailWisata::class.java)
            //put Extra
            intent.putExtra("ImgWisata", listitemwisata[position].ImgWisata)
            intent.putExtra("NamaWisata",listitemwisata[position].NamaWisata)
            intent.putExtra("LokasiWisata",listitemwisata[position].LokasiWisata)

            // tambahkan latitude longitude
            intent.putExtra("latitude",listitemwisata[position].latitude)
            intent.putExtra("longitude",listitemwisata[position].longitude)



            getdetailWisata.startActivity(intent)

            Toast.makeText(getdetailWisata,listitemwisata[position].NamaWisata, Toast.LENGTH_SHORT).show()

        }
    }
}