package ee.taltech.ylesanne4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ee.taltech.ylesanne4.adapters.RoomsAdapter
import ee.taltech.ylesanne4.api.Common
import ee.taltech.ylesanne4.api.RetrofitServices
import ee.taltech.ylesanne4.pojo.Room
import kotlinx.android.synthetic.main.activity_main.*
//import io.reactivex.Observable
//import io.reactivex.annotations.SchedulerSupport.IO
//import kotlinx.coroutines.*
//import org.json.JSONArray
import retrofit2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var roomsService: RetrofitServices
lateinit var roomsLayout: LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Rooms name list";
        roomsService = Common.retrofitService
        roomsLayout = LinearLayoutManager(this)
        getAllRooms()
    }

    private fun getAllRooms() {
        roomsService.getRooms().enqueue(object : Callback<MutableList<Room>> {
            override fun onFailure(call: Call<MutableList<Room>>, t: Throwable) {
                Log.e("onFailure: ", "${t.message}")
            }

            override fun onResponse(
                call: Call<MutableList<Room>>,
                response: Response<MutableList<Room>>
            ) {
                Log.e("onResponse: ", "${response.message()}")
                Log.e("bodySize: ", "${response.body()?.size}")
                if (response.body() != null && response.body()?.size!! > 0)
                    recycler_rooms.apply {
                        setHasFixedSize(true)
                        adapter = RoomsAdapter(response.body()!!)
                        layoutManager = roomsLayout
                        addItemDecoration(
                            DividerItemDecoration(
                                this@MainActivity, DividerItemDecoration.VERTICAL
                            )
                        )
                    }
            }
        })
    }
}