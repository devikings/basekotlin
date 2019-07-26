package br.com.brunocardoso.apps.base_kotlin.ui.phonebook

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.brunocardoso.apps.base_kotlin.shared.base.BasePresenter
import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact
import br.com.brunocardoso.apps.base_kotlin.shared.repository.PhoneBookRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
class PhoneBookPresenter(
    application: Application,
    private val view: PhoneBookView,
    private val repository: PhoneBookRepository = PhoneBookRepository(application),
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
) : BasePresenter {

    var listContact: LiveData<List<Contact>> = MutableLiveData<List<Contact>>()

    fun getPhones() {
        compositeDisposable.add(
            repository.getcontacts()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ contacts ->
                    listContact = MutableLiveData(contacts)
                    view.fillPhones(contacts)
                }, { error -> view.showDialogError(error.message!!) })
        )
    }

    override fun attach() {
        compositeDisposable.clear()
    }
}