package com.crype.entertoapp.data.repository

import android.app.Activity
import android.util.Log
import com.crype.entertoapp.domain.model.AuthResult
import com.crype.entertoapp.domain.model.UserInfo
import com.crype.entertoapp.domain.repository.EnterCodeRepository
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class EnterCodeRepositoryImpl : EnterCodeRepository {

    private val auth = FirebaseAuth.getInstance()
    private var storedVerificationId: String? = null
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null

    private var callback: ((AuthResult) -> Unit)? = null

    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            callback?.invoke(AuthResult.Error(e.message ?: "Ошибка аутентификации"))
        }

        override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
            storedVerificationId = verificationId
            resendToken = token
            callback?.invoke(AuthResult.CodeSent(verificationId, token))
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback?.invoke(AuthResult.Success(credential))
                } else {
                    callback?.invoke(AuthResult.Error(task.exception?.message ?: "Ошибка входа"))
                }
            }
    }

    override fun sendVerificationCode(phoneNumber: String, activity: Activity, callback: (AuthResult) -> Unit) {
        this.callback = callback
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    override fun verifyCode(code: String, callback: (AuthResult) -> Unit) {
        this.callback = callback
        storedVerificationId?.let {
            val credential = PhoneAuthProvider.getCredential(it, code)
            signInWithPhoneAuthCredential(credential)
        } ?: callback(AuthResult.Error("Verification ID отсутствует"))
    }

    override fun getUserInfo(): UserInfo {
        val user = auth.currentUser
        return UserInfo(
            phoneNumber = user?.phoneNumber ?: "Неизвестный номер",
            userID = user?.uid ?: "Неизвестный ID"
        )
    }
}