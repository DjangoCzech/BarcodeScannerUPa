package com.panus.barcodeupanew

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

//create adapter for recycler view
class BarcodeAdapter(
    var barcodes: List<Barcode>,
    var mContext: Context
) : RecyclerView.Adapter<BarcodeAdapter.BarcodeViewHolder>() {
    inner class BarcodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvTitle: TextView = itemView.tvTitle

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            Toast.makeText(itemView.context, "You clicked on ${barcodes[position].title}", Toast.LENGTH_SHORT).show()
            val intent = Intent(mContext, SecondActivity::class.java)
            intent.putExtra("scannedBarcode", barcodes[position].title)
            mContext.startActivity(intent)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarcodeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,
            parent, false)
        return BarcodeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BarcodeViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = barcodes[position].title
        }
    }

    override fun getItemCount(): Int {
        return barcodes.size
    }
}