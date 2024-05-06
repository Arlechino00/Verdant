package com.example.verdant.ui.discover


import androidx.lifecycle.ViewModel
import com.example.verdant.data.Plant
import com.example.verdant.data.local.Plants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class ListUiState(
    val plantList: List<Plant> = emptyList(),
    val currentPlant: Plant = Plants.defaultPlant,
    val isShowingListPage: Boolean = true
)

class PlantViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        ListUiState(
            plantList = Plants.getPlants(),
            currentPlant = Plants.getPlants().getOrElse(0){
                Plants.defaultPlant
            }
        )
    )

    val uiState: StateFlow<ListUiState> = _uiState

    fun updateCurrentPlant(selectedPlant: Plant){
        _uiState.update {
            it.copy(currentPlant= selectedPlant)
        }
    }

    fun navigateToListPage(){
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    fun navigateToDetailPage(){
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}