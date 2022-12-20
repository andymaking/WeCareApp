package io.king.wecareapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.king.wecareapp.data.network.Resource
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.data.responses.AllAssignedResidentsResponse
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repository: UserRepository
): ViewModel(){
    var id: String = ""
    private val _getAssignedResidents : MutableLiveData<Resource<AllAssignedResidentsResponse>> = MutableLiveData()
    val getAssignedResidents: LiveData<Resource<AllAssignedResidentsResponse>>
        get() = _getAssignedResidents

    fun getAssignedResidents(
        id: String
    ) = viewModelScope.launch {
        _getAssignedResidents.value = repository.getAssignedResidents(id)
    }
}