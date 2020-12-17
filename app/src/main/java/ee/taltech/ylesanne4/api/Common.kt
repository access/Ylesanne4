package ee.taltech.ylesanne4.api

object Common {
    private val BASE_URL = "https://dev.vk.edu.ee/~natalia/hitsaproject/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}