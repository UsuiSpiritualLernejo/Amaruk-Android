package usl.amaruk.viewmodel

import androidx.annotation.Keep
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import usl.amaruk.apimanager.ApiCallsHandler
import usl.amaruk.apimanager.ErrorEmitter
import usl.amaruk.repository.ApiRepository
import usl.amaruk.utils.ErrorType
import usl.amaruk.utils.UIEventManager
import java.util.*

class AuthViewModel(private val eventManager: UIEventManager) : ViewModel(), ErrorEmitter {
    private val apiRepository = ApiRepository()

    fun userLogin(email: String?, password: String?, lang: String?) = liveData {
        eventManager.viewProgressBar()
        val userResponse = ApiCallsHandler.safeApiCall(this@AuthViewModel) {
            apiRepository.userLogin(email, password, lang)
        }
        eventManager.stopProgressBar()
        emit(userResponse)
    }

    fun forgotPassword(email: String, lang: String) = liveData {
        eventManager.viewProgressBar()
        val forgotPasswordResponse = ApiCallsHandler.safeApiCall(this@AuthViewModel) {
            apiRepository.forgotPassword(email, lang)
        }
        eventManager.stopProgressBar()
        emit(forgotPasswordResponse)
    }

    override fun onError(msg: String) {
        eventManager.viewToast(msg)
    }

    override fun onError(errorType: ErrorType) {
        //eventManager.viewToast(errorType.toString())
    }
}