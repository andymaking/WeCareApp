package io.king.wecareapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import io.king.wecareapp.R
import io.king.wecareapp.data.network.AuthApi
import io.king.wecareapp.data.network.Resource
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.AuthRepository
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.data.responses.User
import io.king.wecareapp.data.room.UserDataBase
import io.king.wecareapp.databinding.FragmentHomeBinding
import io.king.wecareapp.databinding.FragmentLoginBinding
import io.king.wecareapp.ui.auth.AuthViewModel
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.enable
import io.king.wecareapp.ui.starttNewActivity
import io.king.wecareapp.ui.visible
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, UserRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var users: List<User>
        var id: String
        lifecycleScope.launch {
            users = room.dao.getUser()
            binding.textView.text = "Hello, ${users[0].name}"
            viewModel.id = "${users[0]._id}"
        }


        binding.myProfile.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
        binding.viewResidence.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_residentFragment)
        }
        binding.fillReport.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_reportFragment)
        }

        viewModel.getAssignedResidents.observe(viewLifecycleOwner, Observer {

            when(it){
                is Resource.Success -> {
                    lifecycleScope.launch{
                        print(it)
                    }
                    Toast.makeText(requireContext(), it.value.message, Toast.LENGTH_LONG).show()
                    requireActivity().starttNewActivity(HomeActivity::class.java)
                }
                is Resource.Failure -> {
                    print(it)
//                    Toast.makeText(requireContext(), "Login failure", Toast.LENGTH_LONG).show()
                }
                is Resource.Loading ->{
                    print(it)
                }
            }
        })

    }

    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))

}