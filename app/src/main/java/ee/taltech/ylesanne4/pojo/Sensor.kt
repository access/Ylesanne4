package ee.taltech.ylesanne4.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sensor(
    @SerializedName("controllersensorid")
    @Expose
    var controllersensorid: Int,
    @SerializedName("sensor_id")
    @Expose
    var sensorId: Int,
    @SerializedName("sensor")
    @Expose
    var sensor: String,
    @SerializedName("sensortype")
    @Expose
    var sensortype: String,
    @SerializedName("room")
    @Expose
    var room: String,
    @SerializedName("controller_id")
    @Expose
    var controllerId: Int,
    @SerializedName("controller")
    @Expose
    var controller: String,
    @SerializedName("last_date")
    @Expose
    var lastDate: String,
    @SerializedName("valuetype")
    @Expose
    var valuetype: String,
    @SerializedName("dimension")
    @Expose
    var dimension: String,
    @SerializedName("typevalueid")
    @Expose
    var typevalueid: Int,
    @SerializedName("datavalue")
    @Expose
    var datavalue: String,
    @SerializedName("picture")
    @Expose
    var picture: String,
)