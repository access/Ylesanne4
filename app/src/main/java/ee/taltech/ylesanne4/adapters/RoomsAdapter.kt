package ee.taltech.ylesanne4.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import ee.taltech.ylesanne4.R
import ee.taltech.ylesanne4.SensorsActivity
import ee.taltech.ylesanne4.pojo.Room
import kotlinx.android.synthetic.main.item_room.view.*

class RoomsAdapter(var list: MutableList<Room>) :
    RecyclerView.Adapter<RoomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_room, parent, false
        )
        return RoomViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.roomName.text = list[position].room
        holder.roomName.setOnClickListener {
            val intent = Intent(holder.roomName.context, SensorsActivity::class.java)
            intent.putExtra("room", list[position].room)
            startActivity(holder.roomName.context, intent, null)
        }
    }
}

class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val roomName: TextView = itemView.txtRoom
}

