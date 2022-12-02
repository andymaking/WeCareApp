package io.king.wecareapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.viewbinding.ViewBinding
import io.king.wecareapp.data.UserPreferences
import io.king.wecareapp.data.network.RemoteDataSource
import io.king.wecareapp.data.repository.BaseRepository
import io.king.wecareapp.data.room.UserDataBase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

abstract class BaseFragment <VM: ViewModel, B: ViewBinding, R: BaseRepository> : Fragment() {

    protected lateinit var userPreferences: UserPreferences
    protected lateinit var binding: B
    protected lateinit var viewModel : VM
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userPreferences = UserPreferences(requireContext())
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())


        lifecycleScope.launch {
            userPreferences.authToken.first()
        }
        return binding.root
    }

    abstract fun getViewModel() : Class<VM>
    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B
    abstract fun getFragmentRepository() : R
}