package io.king.wecareapp.ui.home.report.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.king.wecareapp.data.dummy.ViewAdapter
import io.king.wecareapp.data.dummy.dropDownList
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.databinding.FragmentActivityBinding
import io.king.wecareapp.databinding.FragmentReportBinding
import io.king.wecareapp.ui.base.BaseFragment

class ActivityFragment : BaseFragment<ActivityViewModel, FragmentActivityBinding, UserRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goBackButton.setOnClickListener{
            findNavController().popBackStack()
        }
    }


    override fun getViewModel() = ActivityViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentActivityBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))

}