package io.king.wecareapp.ui.home.proflie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import io.king.wecareapp.R
import io.king.wecareapp.data.network.Resource
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.data.responses.User
import io.king.wecareapp.data.room.UserDataBase
import io.king.wecareapp.databinding.FragmentProfileBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.enable
import kotlinx.coroutines.launch

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding, UserRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        var users: List<User>

        lifecycleScope.launch {

            val db = Room.databaseBuilder(
                requireContext(), UserDataBase::class.java,
                "user"
            ).build()

            users = db.dao.getUser()
            binding.profileUsername.text = users[0].name
            binding.profileAddress.text = users[0].address
            binding.profileEmail.text = users[0].email
            binding.profilePhoneNumber.text = users[0].phone
            binding.profileLisence.text = users[0].licenseNo
            binding.profileSex.text = users[0].gender
        }


    }

    override fun getViewModel() = ProfileViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentProfileBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))

}