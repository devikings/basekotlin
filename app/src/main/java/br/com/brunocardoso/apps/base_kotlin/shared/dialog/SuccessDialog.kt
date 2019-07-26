package br.com.brunocardoso.apps.base_kotlin.shared.dialog

import android.content.Context
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import br.com.brunocardoso.apps.base_kotlin.R
import br.com.brunocardoso.apps.base_kotlin.shared.base.BaseDialog
import kotlinx.android.synthetic.main.success_dialog_layout.*

/**
 * @author Bruno Cardoso on 25/07/2019.
 */
class SuccessDialog(
    context: Context,
    private val description: String
) : BaseDialog(context) {

    private val tvDescription: TextView by lazy { dialog_success_tv_description }

    override fun getLayoutRes(): Int = R.layout.success_dialog_layout

    override fun initialize() {
        window?.setLayout(MATCH_PARENT, WRAP_CONTENT)
        hideNegativeButton()
        setPositiveButtonText(R.string.success_dialog_btn_positive_button)
        setPositiveClickListener { dismiss() }
        tvDescription.text = description
    }
}
