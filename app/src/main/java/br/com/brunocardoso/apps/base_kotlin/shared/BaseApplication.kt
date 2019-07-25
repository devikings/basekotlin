package br.com.brunocardoso.apps.base_kotlin.shared

import android.app.Application

/**
 * @author Bruno Cardoso on 23/07/2019.
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // init room
    }
}