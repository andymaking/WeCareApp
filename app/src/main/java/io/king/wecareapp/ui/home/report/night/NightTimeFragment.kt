package io.king.wecareapp.ui.home.report.night

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.king.wecareapp.R
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.databinding.FragmentMedicationBinding
import io.king.wecareapp.databinding.FragmentNightTimeBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.home.report.medication.MedicationViewModel

class NightTimeFragment : BaseFragment<NightTimeViewModel, FragmentNightTimeBinding, UserRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goBackButton.setOnClickListener{
            findNavController().popBackStack()
        }
    }

    override fun getViewModel() = NightTimeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNightTimeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))
}