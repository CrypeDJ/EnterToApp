package com.crype.entertoapp.domain.repository

import android.app.Activity
import com.crype.entertoapp.domain.model.AuthResult
import com.crype.entertoapp.domain.model.UserInfo

interface EnterCodeRepository {
    fun sendVerificationCode(phoneNumber: String, activity: Activity, callback: (AuthResult) -> Unit)
    fun verifyCode(code: String, callback: (AuthResult) -> Unit)
    fun getUserInfo(): UserInfo
}