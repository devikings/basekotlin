package br.com.brunocardoso.apps.base_kotlin.ui.splash

import android.content.Intent
import android.os.Handler
import br.com.brunocardoso.apps.base_kotlin.R
import br.com.brunocardoso.apps.base_kotlin.shared.base.BaseActivity
import br.com.brunocardoso.apps.base_kotlin.ui.phonebook.PhoneBookActivity

class SplashActivity : BaseActivity() {

    override var layoutRes: Int = R.layout.splash_screen_layout

    override fun initialize() {
        Handler().postDelayed({
            startHomeActivity()
        }, SPLASH_DELAY)
    }

    private fun startHomeActivity() {
        startActivity(Intent(this, PhoneBookActivity::class.java))
        finish()
    }

    private companion object {
        private const val SPLASH_DELAY = 2000L
    }
}
