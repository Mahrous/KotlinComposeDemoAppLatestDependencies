package com.mahrous.demo_app.core.rout

sealed class AppScreen(val route: String) {
    object HomeScreen : AppScreen(ConstantAppScreenName.HOME_SCREEN)
    object SignInScreen : AppScreen(ConstantAppScreenName.SIGN_IN_SCREEN)
    object CategoriesScreen : AppScreen(ConstantAppScreenName.CATEGORIES_SCREEN)
    object SignUpScreen : AppScreen(ConstantAppScreenName.SIGN_UP_SCREEN)
    object VerificationScreen : AppScreen(ConstantAppScreenName.VERIFICATION_SCREEN)
    object CategoryProductsScreen : AppScreen(ConstantAppScreenName.CATEGORY_PRODUCTS_SCREEN)
    object PhoneVerifiedScreen : AppScreen(ConstantAppScreenName.PHONE_VERIFIED_SCREEN)
    object ProductDetailsScreen : AppScreen(ConstantAppScreenName.PRODUCT_DETAILS_SCREEN)
    object CartScreen : AppScreen(ConstantAppScreenName.CART_SCREEN)
    object CheckoutScreen : AppScreen(ConstantAppScreenName.CHECKOUT_SCREEN)
    object OrderSuccessScreen : AppScreen(ConstantAppScreenName.ORDER_SUCCESS_SCREEN)
    object PrescriptionScreen : AppScreen(ConstantAppScreenName.PRESCRIPTION_SCREEN)
    object PrescriptionCheckoutScreen : AppScreen(ConstantAppScreenName.PRESCRIPTION_CHECKOUT_SCREEN)
    object NonPrescriptionCheckoutScreen : AppScreen(ConstantAppScreenName.NON_PRESCRIPTION_CHECKOUT_SCREEN)
    object ProfileScreen : AppScreen(ConstantAppScreenName.PROFILE_SCREEN)
    object NotificationsScreen : AppScreen(ConstantAppScreenName.NOTIFICATIONS_SCREEN)
    object EmptyCartScreen : AppScreen(ConstantAppScreenName.EMPTY_CART_SCREEN)
    object RxUploadScreen : AppScreen(ConstantAppScreenName.RX_UPLOAD_SCREEN)

}


object ConstantAppScreenName {
    const val HOME_SCREEN = "home_screen"
    const val SIGN_IN_SCREEN = "sign_in_screen"
    const val CATEGORIES_SCREEN = "categories_screen"
    const val SIGN_UP_SCREEN = "sign_up_screen"
    const val VERIFICATION_SCREEN = "verification_screen"
    const val CATEGORY_PRODUCTS_SCREEN = "category_products_screen"
    const val PHONE_VERIFIED_SCREEN = "phone_verified_screen"
    const val PRODUCT_DETAILS_SCREEN = "product_details_screen"
    const val CART_SCREEN = "cart_screen"
    const val CHECKOUT_SCREEN = "checkout_screen"
    const val ORDER_SUCCESS_SCREEN = "order_success_screen"
    const val PRESCRIPTION_SCREEN = "prescription_screen"
    const val PRESCRIPTION_CHECKOUT_SCREEN = "prescription_checkout_screen"
    const val NON_PRESCRIPTION_CHECKOUT_SCREEN = "non_prescription_checkout_screen"
    const val PROFILE_SCREEN = "profile_screen"
    const val NOTIFICATIONS_SCREEN = "notifications_screen"
    const val EMPTY_CART_SCREEN = "empty_cart_screen"
    const val RX_UPLOAD_SCREEN = "rx_upload_screen"

}