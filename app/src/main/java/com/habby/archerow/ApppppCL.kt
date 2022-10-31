package com.habby.archerow

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ApppppCL: Application() {
    companion object {
        const val AF_DEV_KEY = "9JnsghqprDTN78N4p9WDJZ"
        const val jsoupCheck = "2v3v"
        const val ONESIGNAL_APP_ID = "5d42d523-fc67-4917-be70-3941cf5ee959"

        val linkAppsCheckPart1 = "http://enchanted"
        val linkAppsCheckPart2 = "angel.xyz/apps.txt"

        val odone = "sub_id_1="

        var MAIN_ID: String? = ""
        var C1: String? = "c11"
        var D1: String? = "d11"
        var CH: String? = "check"

    }

    override fun onCreate() {
        super.onCreate()

        GlobalScope.launch(Dispatchers.IO) {
            applyDeviceId(context = applicationContext)
        }
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }

    private suspend fun applyDeviceId(context: Context) {
        val advertisingInfo = Adv(context)
        val idInfo = advertisingInfo.getAdvertisingId()

        val prefs = getSharedPreferences("SP", MODE_PRIVATE)
        val editor = prefs.edit()

        editor.putString(MAIN_ID, idInfo)
        editor.apply()
    }

}

class Adv (context: Context) {
    private val adInfo = AdvertisingIdClient(context.applicationContext)

    suspend fun getAdvertisingId(): String =
        withContext(Dispatchers.IO) {
            adInfo.start()
            val adIdInfo = adInfo.info
            Log.d("getAdvertisingId = ", adIdInfo.id.toString())
            adIdInfo.id
        }
}