package com.crype.entertoapp.core.common

import com.crype.entertoapp.R
import com.crype.entertoapp.domain.model.CountryCodeModel

object CountryCodes {
    val USA = CountryCodeModel("+1", "USA", R.drawable.usa)
    val RUSSIA = CountryCodeModel("+7", "Russia", R.drawable.russia)
    val BELARUS = CountryCodeModel("+375", "Belarus", R.drawable.belarus)

    val countries = listOf(USA, RUSSIA, BELARUS)
}