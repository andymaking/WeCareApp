package io.king.wecareapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.king.wecareapp.data.repository.AuthRepository
import io.king.wecareapp.data.repository.BaseRepository
import io.king.wecareapp.data.repository.UserRepository
import io.king.wecareapp.ui.auth.AuthViewModel
import io.king.wecareapp.ui.home.HomeViewModel
import io.king.wecareapp.ui.home.proflie.ProfileViewModel
import io.king.wecareapp.ui.home.report.ReportViewModel
import io.king.wecareapp.ui.home.report.activity.ActivityViewModel
import io.king.wecareapp.ui.home.report.food_drink.FoodDrinksViewModel
import io.king.wecareapp.ui.home.report.medication.MedicationViewModel
import io.king.wecareapp.ui.home.report.night.NightTimeViewModel
import io.king.wecareapp.ui.home.report.pearsonalCare.PersonalCareViewModel
import io.king.wecareapp.ui.home.report.safety.SafetyViewModel
import io.king.wecareapp.ui.home.report.toilet.ToiletViewModel
import io.king.wecareapp.ui.home.residents.ResidentViewModel

class ViewModelFactory (
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> ProfileViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(ResidentViewModel::class.java) -> ResidentViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(ReportViewModel::class.java) -> ReportViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(ActivityViewModel::class.java) -> ActivityViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(FoodDrinksViewModel::class.java) -> FoodDrinksViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(MedicationViewModel::class.java) -> MedicationViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(NightTimeViewModel::class.java) -> NightTimeViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(PersonalCareViewModel::class.java) -> PersonalCareViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(SafetyViewModel::class.java) -> SafetyViewModel(repository as UserRepository) as T
            modelClass.isAssignableFrom(ToiletViewModel::class.java) -> ToiletViewModel(repository as UserRepository) as T
            else -> throw IllegalArgumentException("ViewModel Class Not Found")
        }
    }
}