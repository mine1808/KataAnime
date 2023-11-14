package com.example.kataanime

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.kataanime.databinding.ActivityMainBinding
import com.example.kataanime.model.Users
import com.example.kataanime.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        val userList = ArrayList<String>()

        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                val thisResult = response.body()
                val data = thisResult?.data?: emptyList()
                if (data.isNotEmpty()) {
                    for (i in data){
                        userList.add(i.english)
                        userList.add(i.indo)
                        userList.add(i.character)
                        userList.add(i.anime)
                    }
                }
                println("this user list ${userList.size}")
                println("this data ${response.body()?.data?.size}")

                val listAdapter = ArrayAdapter(
                    this@MainActivity,
                    R.layout.simple_list_item_1,
                    userList
                )

                binding.lvKata.adapter = listAdapter
            }
            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Koneksi error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}