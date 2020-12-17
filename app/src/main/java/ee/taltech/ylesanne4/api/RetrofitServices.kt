package ee.taltech.ylesanne4.api

import ee.taltech.ylesanne4.pojo.Room
import ee.taltech.ylesanne4.pojo.Sensor
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("api/room")
    fun getRooms(): Call<MutableList<Room>>

    @GET("api/room/{room}/currentall")
    fun getRoomData(@Path("room") name: String): Call<MutableList<Sensor>>
}