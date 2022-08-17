package com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.ecommerceappjetpackcompose.R
import com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens.ProductDetails

class SharedViewModel:ViewModel() {

    val productDetailsList = listOf<ProductDetails>(
        ProductDetails(
            name = "Zeb-MAX",
            details = "ZEBRONICS Zeb-MAX Play Windows Compatible 2.4GHz Wireless Gamepad with 10H* Backup, Turbo Mode, Dual Vibration Motors, Quad Front triggers, Type C Rechargeable and Plug & Play Setup",
            price = 1070,
            image = R.drawable.zebmax,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Redgear Pro Wireless",
            details = "Redgear Pro Wireless Gamepad with 2.4GHz Wireless Technology, Integrated Dual Intensity Motor, Illuminated Keys for PC(Compatible with Windows 7/8/8.1/10 only)",
            price = 1299,
            image = R.drawable.redgear,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "Cosmic Byte C1070T",
            details = "ZEBRONICS Zeb-MAX Play Windows Compatible 2.4GHz Wireless Gamepad with 10H* Backup, Turbo Mode, Dual Vibration Motors, Quad Front triggers, Type C Rechargeable and Plug & Play Setup",
            price = 1419,
            image = R.drawable.cosmic,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "RPM Euro Games",
            details = "Eccentric 360 and #x2DA\n" +
                    "Double triggers and analog bumpers, 1 Year Warranty\n" +
                    "analog sticks for more comfort,Ultra-precise eight-way D Cross\n" +
                    "Integrated Dual Mode: X-input and Direct-input for greater games compatibility\n" +
                    "Dongle should be directly in sight of controller",
            price = 898,
            image = R.drawable.rpm,
            trending = "Trending Now"
        )
    )

    var selectedProduct :ProductDetails = productDetailsList.first()

    val favoriteProducts = mutableStateListOf<ProductDetails>()

    val cartProducts = mutableStateListOf<ProductDetails>()
}