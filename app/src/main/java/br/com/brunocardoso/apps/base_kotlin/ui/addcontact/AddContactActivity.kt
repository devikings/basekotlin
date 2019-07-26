package br.com.brunocardoso.apps.base_kotlin.ui.addcontact

import android.app.Activity
import android.text.Editable
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import br.com.brunocardoso.apps.base_kotlin.R
import br.com.brunocardoso.apps.base_kotlin.shared.base.BaseActivity
import br.com.brunocardoso.apps.base_kotlin.shared.dialog.ErrorDialog
import br.com.brunocardoso.apps.base_kotlin.shared.dialog.SuccessDialog
import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact
import br.com.brunocardoso.apps.base_kotlin.shared.util.TextWatcherAdapter
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.add_contact_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class AddContactActivity : BaseActivity(), AddContactView {

    private lateinit var presenter: AddContactPresenter

    private val tbAddContact: Toolbar by lazy { toolbar }
    private val etName: EditText by lazy { add_contact_et_name }
    private val etPhone: EditText by lazy { add_contact_et_phone }
    private val btnSave: MaterialButton by lazy { add_contact_btn_save }

    private var textWatcherAdapter: TextWatcherAdapter =
        object : TextWatcherAdapter {
            override fun afterTextChanged(p0: Editable?) {
                presenter.checkInputs(etName.text.toString(), etPhone.text.toString())
            }
        }

    override var layoutRes: Int = R.layout.add_contact_layout

    override fun initialize() {
        presenter = AddContactPresenter(application, this)
        etName.addTextChangedListener(textWatcherAdapter)
        etPhone.addTextChangedListener(textWatcherAdapter)

        btnSave.setOnClickListener {
            presenter.saveContact(Contact(etName.text.toString(), etPhone.text.toString()))
        }

        tbAddContact.title = getString(R.string.title_activity_add_contact)
        setSupportActionBar(tbAddContact)
    }

    override fun enableSaveButton(enable: Boolean) {
        btnSave.isEnabled = enable
    }

    override fun showDialogSuccess() {
        val dialog = SuccessDialog(this, getString(R.string.success_dialog_tv_positive_description))
        dialog.show()
        dialog.setPositiveClickListener {
            setResult(Activity.RESULT_OK)
            finish()
            dialog.dismiss()
        }

    }

    override fun showDialogError(error: String) {
        val dialog = ErrorDialog(this, getString(R.string.error_dialog_tv_desc))
        dialog.show()
    }
}
