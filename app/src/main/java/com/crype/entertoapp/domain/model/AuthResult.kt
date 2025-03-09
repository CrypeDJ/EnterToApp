package com.crype.entertoapp.domain.model

import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

sealed class AuthResult {
    data class Success(val credential: PhoneAuthCredential) : AuthResult()
    data class Error(val message: String) : AuthResult()
    data class CodeSent(val verificationId: String, val token: PhoneAuthProvider.ForceResendingToken) : AuthResult()
}