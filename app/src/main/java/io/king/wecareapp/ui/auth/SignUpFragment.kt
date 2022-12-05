package io.king.wecareapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import io.king.wecareapp.R
import io.king.wecareapp.data.network.AuthApi
import io.king.wecareapp.data.network.Resource
import io.king.wecareapp.data.repository.AuthRepository
import io.king.wecareapp.databinding.FragmentSignUpBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.enable

class SignUpFragment : BaseFragment<AuthViewModel, FragmentSignUpBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.registerSignin.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        binding.signupButton.enable(false)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success -> {
                    findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Registration failure", Toast.LENGTH_LONG).show()
                }
                is Resource.Loading ->{

                }
            }
        })

        binding.signupPassword.addTextChangedListener {
            val first = binding.signupUsername.text.toString().trim()
            val last = binding.signupUsername.text.toString().trim()
            val email = binding.signupUsername.text.toString().trim()
            val username = binding.signupUsername.text.toString().trim()
            val password = binding.signupPassword.text.toString().trim()
            binding.signupButton.enable(password.isNotEmpty() && username.isNotEmpty() && last.isNotEmpty() && first.isNotEmpty() && email.isNotEmpty() && it.toString().isNotEmpty())
        }

        binding.signupButton.setOnClickListener {
            val firtname = binding.signupFirstName.text.toString().trim()
            val email = binding.signupEmail.text.toString().trim()
            val lastName = binding.signupLastName.text.toString().trim()
            val password = binding.signupPassword.text.toString().trim()
            val userName = binding.signupUsername.text.toString().trim()

            viewModel.signUp(email, password, "", lastName, firtname, userName)
        }
    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSignUpBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()=
        AuthRepository(remoteDataSource.buildApi(AuthApi::class.java), userPreferences)

}