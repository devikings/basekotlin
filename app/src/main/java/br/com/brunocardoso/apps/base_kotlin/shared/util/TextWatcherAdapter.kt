package br.com.brunocardoso.apps.base_kotlin.shared.util

import android.text.Editable
import android.text.TextWatcher

/**
 * @author Bruno Cardoso on 25/07/2019.
 */
interface TextWatcherAdapter : TextWatcher {
    override fun afterTextChanged(p0: Editable?) {
        // unused
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // unused
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // unused
    }
}