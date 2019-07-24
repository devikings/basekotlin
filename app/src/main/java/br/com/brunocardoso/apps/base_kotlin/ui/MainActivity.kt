package br.com.brunocardoso.apps.base_kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.brunocardoso.apps.base_kotlin.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
