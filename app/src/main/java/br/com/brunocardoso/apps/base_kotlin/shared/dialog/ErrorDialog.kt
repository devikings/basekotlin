package br.com.brunocardoso.apps.base_kotlin.shared.dialog

import android.content.Context
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import br.com.brunocardoso.apps.base_kotlin.R
import br.com.brunocardoso.apps.base_kotlin.shared.base.BaseDialog
import kotlinx.android.synthetic.main.error_dialog_layout.*

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
class ErrorDialog(
    context: Context,
    private val description: String
) : BaseDialog(context) {

    private val tvDescription: TextView by lazy { dialog_error_tv_description }

    override fun getLayoutRes(): Int = R.layout.error_dialog_layout

    override fun initialize() {
        window?.setLayout(MATCH_PARENT, WRAP_CONTENT)
        hideNegativeButton()
        setPositiveButtonText(R.string.error_dialog_btn_positive_button)
        setPositiveClickListener { dismiss() }
        tvDescription.text = description
    }
}
