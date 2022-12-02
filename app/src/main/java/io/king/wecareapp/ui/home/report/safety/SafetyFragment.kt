package io.king.wecareapp.ui.home.report.safety

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.king.wecareapp.R
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.databinding.FragmentPersonalCareBinding
import io.king.wecareapp.databinding.FragmentSafetyBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.home.report.pearsonalCare.PersonalCareViewModel


class SafetyFragment : BaseFragment<SafetyViewModel, FragmentSafetyBinding, UserRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goBackButton.setOnClickListener{
            findNavController().popBackStack()
        }
    }

    override fun getViewModel() = SafetyViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSafetyBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))
}