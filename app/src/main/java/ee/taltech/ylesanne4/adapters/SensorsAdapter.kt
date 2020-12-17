package ee.taltech.ylesanne4.adapters

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import ee.taltech.ylesanne4.R
import ee.taltech.ylesanne4.pojo.Sensor
import kotlinx.android.synthetic.main.item_sensor.view.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class SensorsAdapter(var list: MutableList<Sensor>) :
    RecyclerView.Adapter<SensorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_sensor, parent, false
        )
        return SensorViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: SensorViewHolder, position: Int) {
        holder.sensorController.text = "${list[position].lastDate.dropLast(7)} - ${list[position].controller} "
        holder.sensorName.text = list[position].sensor
        holder.sensorNameDetails.text =
            "${list[position].valuetype}: ${list[position].datavalue} ${list[position].dimension}"
        Log.e("sensor: ", list[position].toString())
    }
}

class SensorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val sensorController: MaterialTextView = itemView.txt_sensor_controller
    val sensorName: MaterialTextView = itemView.txt_sensor
    val sensorNameDetails: MaterialTextView = itemView.txt_sensor_details
}

