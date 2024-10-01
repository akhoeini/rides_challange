package com.amin.rides.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amin.rides.R
import com.amin.rides.data.Vehicle

class VehiclesAdapter(private val onItemClicked:(item:Vehicle) ->Unit ) : RecyclerView.Adapter<VehiclesAdapter.ViewHolder>() {
    private var vehicles: List<Vehicle>? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var makeModel: TextView = itemView.findViewById(R.id.make_model_tv)
        var vin: TextView = itemView.findViewById(R.id.vin_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vehicle_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position > itemCount) {
            return
        }
        val vehicle = vehicles!![position]

        holder.makeModel.text = vehicle.makeModel
        holder.vin.text = vehicle.vin

        holder.itemView.setOnClickListener {
            onItemClicked.invoke(vehicle)
        }
    }


    override fun getItemCount(): Int {
        return if (vehicles == null) 0 else vehicles!!.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(vehicles: List<Vehicle>) {
        this.vehicles = vehicles
        notifyDataSetChanged()
    }
}