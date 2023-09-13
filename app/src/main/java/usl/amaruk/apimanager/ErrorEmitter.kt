package usl.amaruk.apimanager

import usl.amaruk.utils.ErrorType


interface ErrorEmitter {
    fun onError(msg: String)
    fun onError(errorType: ErrorType)
}