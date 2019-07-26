package br.com.brunocardoso.apps.base_kotlin.shared.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import br.com.brunocardoso.apps.base_kotlin.R
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.base_dialog_layout.*

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
abstract class BaseDialog(context: Context) : Dialog(context) {

    private val btnNegative: MaterialButton by lazy { dialog_base_bt_negative }
    private val btnPositive: MaterialButton by lazy { dialog_base_bt_positive }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.base_dialog_layout)
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog_base_fl_content.addView(LayoutInflater.from(context).inflate(getLayoutRes(), null))
        initialize()
    }

    protected fun setPositiveButtonText(@StringRes stringRes: Int) {
        btnPositive.text = context.getString(stringRes)
    }

    fun setPositiveClickListener(positiveClickListener: (View) -> Unit) {
        btnPositive.setOnClickListener(positiveClickListener)
    }

    protected fun showPositiveButton() {
        btnPositive.visibility = View.VISIBLE
    }

    protected fun hidePositiveButton() {
        btnPositive.visibility = View.GONE
    }

    protected fun setNegativeButtonText(@StringRes stringRes: Int) {
        btnNegative.text = context.getString(stringRes)
    }

    protected fun setNegativeClickListener(negativeClickListener: (View) -> Unit) {
        btnNegative.setOnClickListener(negativeClickListener)
    }

    protected fun hideNegativeButton() {
        btnNegative.visibility = View.GONE
    }

    protected fun showNegativeButton() {
        btnNegative.visibility = View.VISIBLE
    }
}
