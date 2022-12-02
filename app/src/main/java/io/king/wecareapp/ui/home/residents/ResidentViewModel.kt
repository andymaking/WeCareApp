package io.king.wecareapp.ui.home.residents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.king.wecareapp.data.network.Resource
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.data.responses.GetResidentsResponse
import kotlinx.coroutines.launch

class ResidentViewModel (
    private val repository: UserRepository
): ViewModel(){

    private val _getAssignedResidents : MutableLiveData<Resource<GetResidentsResponse>> = MutableLiveData()
    val getAssignedResidents: LiveData<Resource<GetResidentsResponse>>
    get() = _getAssignedResidents

    fun getAssignedResidents(id: String) = viewModelScope.launch {
        _getAssignedResidents.value = Resource.Loading
        _getAssignedResidents.value = repository.getAssignedResidents(id)
    }

}