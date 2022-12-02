package io.king.wecareapp.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.king.wecareapp.data.network.Resource
import io.king.wecareapp.data.repository.AuthRepository
import io.king.wecareapp.data.responses.LoginResponse
import io.king.wecareapp.data.responses.User
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel(){

    // TODO RESPONSE
    private val _loginResponse : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(
        email: String, password: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)
    }

    fun saveAuthToken(token: String) = viewModelScope.launch{
        repository.saveAuthToken(token)
    }
}