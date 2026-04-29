package com.chooloo.www.koler

import android.telecom.TelecomManager
import androidx.preference.PreferenceManager
import com.chooloo.www.chooloolib.ChoolooApp
import com.chooloo.www.chooloolib.notification.CallNotification
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

import com.google.android.material.color.DynamicColors  // add this import

@HiltAndroidApp
class KolerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)  // ← add this line
        // ... rest of your existing code
    }
}

@HiltAndroidApp
open class KolerApp : ChoolooApp() {
    @Inject lateinit var telecomManager: TelecomManager
    @Inject lateinit var callNotification: CallNotification

    override fun onCreate() {
        super.onCreate()
        PreferenceManager.setDefaultValues(this, R.xml.preferences_koler, false)
    }
}