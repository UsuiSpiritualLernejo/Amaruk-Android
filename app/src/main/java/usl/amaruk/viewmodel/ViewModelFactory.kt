package usl.amaruk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import usl.amaruk.utils.UIEventManager

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val eventManager: UIEventManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(eventManager) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}