package io.king.wecareapp.ui.home.residents

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.king.wecareapp.data.dummy.MyAdapter
import io.king.wecareapp.data.dummy.residentsList
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.data.responses.User
import io.king.wecareapp.databinding.FragmentResidentBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.visible
import kotlinx.coroutines.launch

class ResidentFragment : BaseFragment<ResidentViewModel, FragmentResidentBinding, UserRepository>() {

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        var newUser: List<User>
        var id: String = ""

        lifecycleScope.launch {
            newUser = room.dao.getUser()
            binding.textView.text = "Hello, ${newUser[0].name}"
            id = newUser[0]._id

            viewModel.getAssignedResidents(id)

        }

        binding.progressBar.visible(true)

        val list = residentsList

        val rV = binding.recycle
        val adapter = MyAdapter(list)
        rV.adapter = adapter
        rV.layoutManager = LinearLayoutManager(requireActivity())
        binding.progressBar.visible(false)
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val resident = list[position]
                println(list[position])
                val action = ResidentFragmentDirections.actionResidentFragmentToResidentDetailFragment(resident)
                findNavController().navigate(action)
            }

        })

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun getViewModel() = ResidentViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentResidentBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))
}