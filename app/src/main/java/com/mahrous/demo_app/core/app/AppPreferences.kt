package com.mahrous.demo_app.core.app


import android.util.Log
import com.mahrous.demo_app.core.theme.AppTheme
import com.mahrous.demo_app.features.auth.domain.model.User
import io.paperdb.Paper
import java.util.*


object AppPreferences {

    //region First Use
    //key
    const val FIRST_USE = "FirstUse"

    fun setFirstUse(isFirstUse: Boolean) {
        Paper.book().write(FIRST_USE, isFirstUse)
    }

    fun isFirstUse(): Boolean? {
        return Paper.book().read(FIRST_USE, true)
    }

    const val ACCESS_TOKEN = "AccessToken"
    fun storeCurrentToken(token: String) {
        Log.e("TAG", "storeCurrentToken: $token", )
        Paper.book().write(ACCESS_TOKEN, token)
    }

    fun getCurrentToken(): String {
        val token = Paper.book().read(ACCESS_TOKEN, "")
        return "Bearer $token"
    }

    const val FCM_TOKEN = "FCMToken"
    fun storeCurrentFCMToken(token: String) {
        Log.e("TAG", "storeCurrentFCM_TOKEN: $token", )
        Paper.book().write(FCM_TOKEN, token)
    }

    fun getCurrentFCMToken(): String {
        val token = Paper.book().read(FCM_TOKEN, "")
        return "$token"
    }


    //User region

    const val CURRENT_PHONE = "CurrentPhone"
    fun storeCurrentPhone(phoneNumber: String) {
        Paper.book().write(CURRENT_PHONE, phoneNumber)
    }


    fun getCurrentPhone(): String? {
        return Paper.book().read(CURRENT_PHONE, null)
    }


    const val CURRENT_USER = "CurrentUser"
    const val REMEMBER_ME = "RememberMe"

    fun storeCurrentUser(user: User,  isRememberMe: Boolean) {
        Paper.book().write(CURRENT_USER, user)
        Paper.book().write(REMEMBER_ME, isRememberMe)
    }

    fun getCurrentUser(): User? {
        return Paper.book().read(CURRENT_USER, null)
    }

 fun getRememberMe(): Boolean? {
        return Paper.book().read(REMEMBER_ME, false)
    }


    //endregion

    //region Country
    //key
    private const val CURRENT_COUNTRY = "CurrentCountry"
    fun storeCurrentCountry(country: String) {
        Paper.book().write(CURRENT_COUNTRY, country)
    }
    fun getCurrentCountry(): String {
        return Paper.book().read(CURRENT_COUNTRY, "")!!
    }

    fun getCountryCode(): String {
        return when (getCurrentCountry()) {

            "Saudi Arabia" -> {
                "+966"
            }
            "السعودية" -> {
                "+966"
            }

            "UAE" -> {
                "+971"
            }
            "الامارات" -> {
                "+971"
            }

            "Egypt" -> {
                "+20"
            }

            "مصر" -> {
                "+20"
            }

            else -> {
                "+20"
            }
        }

    }

    //endregion




    //endregion

    //endregion

    //region LanguageConfig
    //key
    const val APP_LANG = "AppLang"

    fun setLocale(lang: String) {
        Paper.book().write(APP_LANG, lang)
    }

    fun getLocale(): String {
        return when (Paper.book().read(APP_LANG, Constants.DEFAULT_SYSTEM_LOCALE_LANG)!!) {
            Constants.DEFAULT_SYSTEM_LOCALE_LANG -> {
                Locale.getDefault().language
            }

            Constants.ARABIC_LOCALE_LANG -> {
                Constants.ARABIC_LOCALE_LANG
            }

            Constants.ENGLISH_LOCALE_LANG -> {
                Constants.ENGLISH_LOCALE_LANG
            }

            else -> {
                Constants.ENGLISH_LOCALE_LANG
            }
        }
    }



    fun getSelectedLanguage(): String {
        return Paper.book().read(APP_LANG, Constants.DEFAULT_SYSTEM_LOCALE_LANG)!!
    }

    //endregion

    //region Theme

    const val APP_THEME = "AppTheme"

    fun setTheme(theme: AppTheme) {
        Paper.book().write(APP_THEME, theme)
    }

    fun getTheme(): AppTheme {
        return Paper.book().read(APP_THEME, AppTheme.Light)!!
    }




    //endregion
//----------------------------------------------------------------------------------------


    fun logout() { // use when logout
        Paper.book().delete(CURRENT_USER)
        Paper.book().delete(REMEMBER_ME)
        Paper.book().delete(ACCESS_TOKEN)

    }




}