package br.com.brunocardoso.apps.base_kotlin.shared.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Bruno Cardoso on 23/07/2019.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}