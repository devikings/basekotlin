package br.com.brunocardoso.apps.base_kotlin.ui.phonebook

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brunocardoso.apps.base_kotlin.R
import br.com.brunocardoso.apps.base_kotlin.shared.base.BaseActivity
import br.com.brunocardoso.apps.base_kotlin.shared.model.Phone
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_phone_book.*
import kotlinx.android.synthetic.main.phone_book_layout.*

class PhoneBookActivity : BaseActivity(), PhoneBookView {

    private lateinit var presenter: PhoneBookPresenter
    private lateinit var adapter: PhoneBookAdapter
    private val recyclerView: RecyclerView by lazy { recyclerview }
    private val floatingActionButton: FloatingActionButton by lazy { fab }

    override var layoutRes: Int = R.layout.phone_book_layout

    override fun initialize() {
        presenter = PhoneBookPresenter(application, this)
        presenter.listPhones.observe(this@PhoneBookActivity, Observer { phones ->
            Snackbar.make(recyclerView, "Total ${phones.size}", Snackbar.LENGTH_LONG)
                .show()
        })

        adapter = PhoneBookAdapter(listOf())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener {
            presenter.addPhone(Phone("Bruno Cardoso", "14 997585108"))
        }

        presenter.getPhones()
    }

    override fun fillPhones(phones: List<Phone>) {
        adapter.setList(phones)
    }

    override fun showDialogSuccess() {
        Snackbar.make(recyclerView, "User saved with success!", Snackbar.LENGTH_LONG)
            .setAction("Ok", null).show()
    }
}
