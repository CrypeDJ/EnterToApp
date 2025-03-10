package com.crype.entertoapp.presentation.viewmodel

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.entertoapp.core.common.CountryCodes
import com.crype.entertoapp.domain.model.AuthResult
import com.crype.entertoapp.domain.model.UserInfo
import com.crype.entertoapp.domain.repository.EnterCodeRepository
import com.crype.entertoapp.presentation.utils.UIConstants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EnterViewModel(
    private val enterCodeRepository: EnterCodeRepository
) : ViewModel() {

    private val _phoneNumber = mutableStateOf("")
    val phoneNumber: State<String> = _phoneNumber

    private val _countryCode = mutableStateOf(CountryCodes.BELARUS)
    val countryCode: State<CountryCodes> = _countryCode

    private val _isActive = mutableStateOf(false)
    val isActive: State<Boolean> = _isActive

    private val _authResult = mutableStateOf<AuthResult?>(null)
    val authResult: State<AuthResult?> = _authResult

    private val _isResendCode = mutableStateOf(true)
    val isResendCode: State<Boolean> = _isResendCode

    private val _code = mutableStateOf(List(UIConstants.NUMBER_IN_CODE) { "" })
    val code: State<List<String>> = _code

    private val _inProgress = mutableStateOf(false)
    val inProgress: State<Boolean> = _inProgress

    private fun updatePhoneNumber(number: String) {
        _phoneNumber.value = number
    }

    private val _timerSeconds = mutableStateOf(0L)

    private fun isDigit(number: String): Boolean {
        return number.matches(Regex("\\d+"))
    }

    fun validateEnterNumber(number: String) {
        val isNumberValid =
            isDigit(number) && number.length <= _countryCode.value.operatorCodeLength + 7

        _isActive.value = number.length == _countryCode.value.operatorCodeLength + 7

        if (isNumberValid || number.isEmpty()) updatePhoneNumber(number)
    }

    fun onContinueNumberButtonClick(activity: Activity) {
        viewModelScope.launch {
            enterCodeRepository.sendVerificationCode(
                phoneNumber = _countryCode.value.codeString + _phoneNumber.value,
                activity = activity
            ) { authResult ->
                _authResult.value = authResult
            }
        }
    }

    fun chooseCountry(country: CountryCodes) {
        _countryCode.value = country
        _phoneNumber.value = ""
    }

    fun formatTimer(): String {
        return String.format("%02d", _timerSeconds.value)
    }

    fun timer() {
        viewModelScope.launch {
            _timerSeconds.value = UIConstants.RESEND_CODE_TIMER
            _isResendCode.value = false
            while (_timerSeconds.value > 0) {
                delay(1000)
                _timerSeconds.value--
            }
            _isResendCode.value = true
        }
    }

    fun enterCodeNumber(index: Int, value: String) {
        if (isDigit(value) || value.isEmpty()) {
            val updatedCode = _code.value.toMutableList().apply {
                this[index] = value
            }
            _code.value = updatedCode
        }
        if (_code.value.all { it.isNotEmpty() }) {
            sendCode()
            toggleProgressBar(true)
        }
    }

    fun listToString(list: List<String>): String {
        return list.joinToString("")
    }

    fun sendCode() {
        viewModelScope.launch {
            enterCodeRepository.verifyCode(code = listToString(_code.value),
                callback = { authResult ->
                    _authResult.value = authResult
                })
        }
    }

    fun getUserInfo() : UserInfo {
        return enterCodeRepository.getUserInfo()
    }

    fun toggleProgressBar(isInProgress: Boolean){
        _inProgress.value = isInProgress
    }
}