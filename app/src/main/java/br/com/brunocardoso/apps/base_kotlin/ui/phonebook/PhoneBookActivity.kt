package br.com.brunocardoso.apps.base_kotlin.ui.phonebook

import android.app.Activity
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brunocardoso.apps.base_kotlin.R
import br.com.brunocardoso.apps.base_kotlin.shared.base.BaseActivity
import br.com.brunocardoso.apps.base_kotlin.shared.dialog.ErrorDialog
import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact
import br.com.brunocardoso.apps.base_kotlin.ui.addcontact.AddContactActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_phone_book.*
import kotlinx.android.synthetic.main.phone_book_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class PhoneBookActivity : BaseActivity(), PhoneBookView {

    private lateinit var presenter: PhoneBookPresenter
    private lateinit var adapter: PhoneBookAdapter
    private val tbPhoneBook: Toolbar by lazy { toolbar }
    private val rvContacts: RecyclerView by lazy { phone_book_rv_contacts }
    private val tvTotal: TextView by lazy { phone_book_tv_total }
    private val floatingActionButton: FloatingActionButton by lazy { fab }

    override var layoutRes: Int = R.layout.phone_book_layout

    override fun initialize() {
        presenter = PhoneBookPresenter(application, this)
        presenter.listContact.observe(this@PhoneBookActivity, Observer { contacts ->
            tvTotal.text = getString(R.string.phone_book_tv_total, contacts.size)
        })

        adapter = PhoneBookAdapter(listOf())
        rvContacts.adapter = adapter
        rvContacts.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener {
            startActivityForResult(Intent(this, AddContactActivity::class.java), ADDCONTACT_REQUEST)
        }

        tbPhoneBook.title = getString(R.string.title_activity_phone_book)
        setSupportActionBar(tbPhoneBook)

        presenter.getPhones()
    }

    override fun fillPhones(contacts: List<Contact>) {
        adapter.setList(contacts)
        tvTotal.text = getString(R.string.phone_book_tv_total, contacts.size)
    }

    override fun showDialogError(error: String) {
        val dialog = ErrorDialog(baseContext, getString(R.string.error_dialog_tv_desc))
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADDCONTACT_REQUEST && resultCode == Activity.RESULT_OK) {
            presenter.getPhones()
        }
    }

    companion object {
        private const val ADDCONTACT_REQUEST = 100
    }
}
