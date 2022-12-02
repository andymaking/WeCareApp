package io.king.wecareapp.ui.home.residents.resDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import io.king.wecareapp.data.dummy.MyAdapter
import io.king.wecareapp.data.dummy.ViewAdapter
import io.king.wecareapp.data.dummy.dropDownList
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.databinding.FragmentResidentDetailBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.home.residents.ResidentViewModel

class ResidentDetailFragment : BaseFragment<ResidentViewModel, FragmentResidentDetailBinding, UserRepository>() {


    private val args: ResidentDetailFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goBackButton.setOnClickListener{
            findNavController().popBackStack()
        }

        binding.profileUsername.text = "${args.residents.name}"

        val list = dropDownList

        val rV = binding.recycleTwo
        val adapter = ViewAdapter(list)
        rV.adapter = adapter
        rV.layoutManager = LinearLayoutManager(requireActivity())


    }

    override fun getViewModel() = ResidentViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentResidentDetailBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))

}