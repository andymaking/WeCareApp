package io.king.wecareapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.king.wecareapp.data.network.Resource
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.data.responses.GetResidentsResponse
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repository: UserRepository
): ViewModel(){


}