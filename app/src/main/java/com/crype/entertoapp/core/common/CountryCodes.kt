package com.crype.entertoapp.core.common

import com.crype.entertoapp.R

enum class CountryCodes(
    val codeString: String,
    val countryName: String,
    val flag: Int,
    val operatorCodeLength: Int
) {
    USA("+1", "USA", R.drawable.usa, 3),
    RUSSIA("+7", "Russia", R.drawable.russia, 3),
    BELARUS(
        "+375", "Belarus", R.drawable.belarus, 2
    );
}