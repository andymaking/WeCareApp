package io.king.wecareapp.ui.home.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.king.wecareapp.R
import io.king.wecareapp.data.dummy.ViewAdapter
import io.king.wecareapp.data.dummy.dropDownList
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.databinding.FragmentReportBinding
import io.king.wecareapp.databinding.FragmentResidentDetailBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.home.residents.ResidentViewModel

class ReportFragment : BaseFragment<ReportViewModel, FragmentReportBinding, UserRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goBackButton.setOnClickListener{
            findNavController().popBackStack()
        }
        binding.personalCare.setOnClickListener{
            findNavController().navigate(R.id.action_reportFragment_to_personalCareFragment)
        }
        binding.safety.setOnClickListener{
            findNavController().navigate(R.id.action_reportFragment_to_safetyFragment)
        }
        binding.foodDrink.setOnClickListener{
            findNavController().navigate(R.id.action_reportFragment_to_foodDrinkFragment)
        }
        binding.actiivty.setOnClickListener{
            findNavController().navigate(R.id.action_reportFragment_to_activityFragment)
        }
        binding.toileting.setOnClickListener{
            findNavController().navigate(R.id.action_reportFragment_to_toiletFragment)
        }
        binding.medication.setOnClickListener{
            findNavController().navigate(R.id.action_reportFragment_to_medicationFragment)
        }
        binding.night.setOnClickListener{
            findNavController().navigate(R.id.action_reportFragment_to_nightTimeFragment)
        }


    }

    override fun getViewModel() = ReportViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentReportBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))

}