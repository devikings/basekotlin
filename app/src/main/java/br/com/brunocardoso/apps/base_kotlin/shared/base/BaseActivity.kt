package br.com.brunocardoso.apps.base_kotlin.shared.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * @author Bruno Cardoso on 23/07/2019.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract var layoutRes: Int

    var frameLayoutId: Int = NO_FRAME_LAYOUT_RES

    protected abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        initialize()
    }

    protected fun openFragment(fragment: Fragment) {
        if (frameLayoutId == NO_FRAME_LAYOUT_RES) {
            return
        }

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(frameLayoutId, fragment, fragment::class.java.simpleName)
            .addToBackStack(fragment::class.java.simpleName)
            .commit()
    }

    companion object {
        private const val NO_FRAME_LAYOUT_RES = 0
    }
}