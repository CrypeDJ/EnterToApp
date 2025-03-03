package com.crype.entertoapp.core.common

import com.crype.entertoapp.R

enum class CountryCodes(val codeString: String, val countryName: String, val flag: Int) {
    USA("+1", "USA", R.drawable.usa),
    RUSSIA("+7", "Russia", R.drawable.russia),
    BELARUS(
        "+375", "Belarus", R.drawable.belarus
    );
}