package ee.taltech.ylesanne4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ee.taltech.ylesanne4.adapters.RoomsAdapter
import ee.taltech.ylesanne4.adapters.SensorsAdapter
import ee.taltech.ylesanne4.api.Common
import ee.taltech.ylesanne4.api.RetrofitServices
import ee.taltech.ylesanne4.pojo.Sensor
import kotlinx.android.synthetic.main.activity_sensors.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SensorsActivity : AppCompatActivity() {
    lateinit var roomService: RetrofitServices
    lateinit var roomsLayout: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensors)
        roomService = Common.retrofitService
        roomsLayout = LinearLayoutManager(this)

        val arguments = intent.extras
        val name = arguments!!["room"].toString()
        if (name != null) {
            title = "Sensor list of room '$name'";
            roomService.getRoomData(name).enqueue(object : Callback<MutableList<Sensor>> {
                override fun onFailure(call: Call<MutableList<Sensor>>, t: Throwable) {
                    Log.e("onFailure: ", "${t.message}")
                }

                override fun onResponse(
                    call: Call<MutableList<Sensor>>,
                    response: Response<MutableList<Sensor>>
                ) {
                    Log.e("onResponse: ", "${response.message()}")
                    Log.e("bodySize: ", "${response.body()?.size}")

                    if (response.body() != null && response.body()?.size!! > 0)
                        recycler_sensors.apply {
                            //setHasFixedSize(true)
                            adapter = SensorsAdapter(response.body()!!)
                            layoutManager = roomsLayout
                            addItemDecoration(
                                DividerItemDecoration(
                                    this.context, DividerItemDecoration.VERTICAL
                                )
                            )
                        }
                }
            })
        }
    }
}