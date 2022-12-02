package io.king.wecareapp.ui.home.report.food_drink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.king.wecareapp.R
import io.king.wecareapp.data.network.UserApi
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.databinding.FragmentFoodDrinkBinding
import io.king.wecareapp.databinding.FragmentNightTimeBinding
import io.king.wecareapp.ui.base.BaseFragment
import io.king.wecareapp.ui.home.report.medication.MedicationViewModel

class FoodDrinkFragment : BaseFragment<FoodDrinksViewModel, FragmentFoodDrinkBinding, UserRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goBackButton.setOnClickListener{
            findNavController().popBackStack()
        }
    }

    override fun getViewModel() = FoodDrinksViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFoodDrinkBinding.inflate(inflater, container, false)

    override fun getFragmentRepository()= UserRepository(remoteDataSource.buildApi(UserApi::class.java))

}