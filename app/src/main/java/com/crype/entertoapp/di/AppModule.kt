package com.crype.entertoapp.di

import com.crype.entertoapp.data.repository.EnterCodeRepositoryImpl
import com.crype.entertoapp.domain.repository.EnterCodeRepository
import com.crype.entertoapp.presentation.viewmodel.EnterViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { EnterViewModel(get()) }
    single<EnterCodeRepository> { EnterCodeRepositoryImpl() }
    single { FirebaseAuth.getInstance() }
}