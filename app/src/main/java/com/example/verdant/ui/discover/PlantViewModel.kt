package com.example.verdant.ui.discover

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.verdant.api.discovery.model.Plant
import com.example.verdant.api.discovery.model.PlantItem
import com.example.verdant.api.discovery.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlantViewModel: ViewModel() {
    private val _plantsData : MutableStateFlow<List<PlantItem>> = MutableStateFlow(listOf())
    val plantsData : StateFlow<List<PlantItem>> = _plantsData

    var loading: Boolean by mutableStateOf(false)

    init {
        retrievePlantsData()
    }

    private fun retrievePlantsData(){
        viewModelScope.launch {
            loading = true
            val call : Call<Plant> = RetrofitInstance.apiService.getAllPlants()
            call.enqueue(object : Callback<Plant> {
                override fun onResponse(
                    call: Call<Plant>,
                    response: Response<Plant>
                ) {
                    if(response.isSuccessful){
                        val responseData: List<PlantItem>? = response.body()?.data
                        if(responseData != null){
                            _plantsData.value = responseData
                        }
                        loading = false
                    } else{
                        loading = false
                    }
                }

                override fun onFailure(call: Call<Plant>, t: Throwable) {
                    loading = false
                    Log.d("Failed Retrieve", "Network Error")
                }

            })
        }
    }
}