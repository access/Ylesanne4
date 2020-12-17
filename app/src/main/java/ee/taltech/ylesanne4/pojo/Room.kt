package ee.taltech.ylesanne4.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("room")
    @Expose
    var room: String
)
