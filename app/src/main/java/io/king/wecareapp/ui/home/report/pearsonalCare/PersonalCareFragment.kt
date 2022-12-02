package io.king.wecareapp.ui.home.report.pearsonalCare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.fragment.findNavController
import io.king.wecareapp.R
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.databinding.FragmentPersonalCareBinding
import io.king.wecareapp.ui.base.BaseFragment

class PersonalCareFragment : BaseFragment<PersonalCareViewModel, FragmentPersonalCareBinding, UserRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        fun checked(main: RadioButton, a:RadioButton, b: RadioButton){
            main.isChecked=true
            a.isChecked=false
            b.isChecked=false
        }




        binding.goBackButton.setOnClickListener{
            findNavController().popBackStack()
        }

        binding.pcN.setOnClickListener{
            checked(binding.pcN, binding.pcY, binding.pcM)
        }
        binding.pcY.setOnClickListener{
            checked(binding.pcY, binding.pcN, binding.pcM)
        }
        binding.pcM.setOnClickListener{
            checked(binding.pcM, binding.pcY, binding.pcN)
        }


    }

    override fun getViewModel() = PersonalCareViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPersonalCareBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))

}