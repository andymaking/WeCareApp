package io.king.wecareapp.ui.home.residents

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import io.king.wecareapp.data.dummy.MyAdapter
import io.king.wecareapp.data.dummy.Resdents
import io.king.wecareapp.data.dummy.residentsList
import io.king.wecareapp.data.network.Resource
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.data.responses.Residentz
import io.king.wecareapp.data.responses.User
import io.king.wecareapp.data.room.UserDataBase
import io.king.wecareapp.databinding.FragmentResidentBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.visible
import kotlinx.coroutines.launch

class ResidentFragment : BaseFragment<ResidentViewModel, FragmentResidentBinding, UserRepository>() {

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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

        var users: List<User>

        lifecycleScope.launch {

            val db = Room.databaseBuilder(
                requireContext(), UserDataBase::class.java,
                "user"
            ).build()

            users = db.dao.getUser()
            viewModel.getAssignedResidents( users[0]._id)
            binding.textView.text = "Hello, ${users[0].name}"
        }
    }

    override fun getViewModel() = ResidentViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentResidentBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))
}