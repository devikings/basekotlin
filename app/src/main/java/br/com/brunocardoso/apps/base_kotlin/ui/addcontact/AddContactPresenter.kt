package br.com.brunocardoso.apps.base_kotlin.ui.addcontact

import android.app.Application
import br.com.brunocardoso.apps.base_kotlin.shared.base.BasePresenter
import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact
import br.com.brunocardoso.apps.base_kotlin.shared.repository.PhoneBookRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * @author Bruno Cardoso on 25/07/2019.
 */
class AddContactPresenter(
    application: Application,
    private val view: AddContactView,
    private val repository: PhoneBookRepository = PhoneBookRepository(application),
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
) : BasePresenter {

    fun saveContact(contact: Contact) {
        compositeDisposable.add(
            repository.save(contact)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showDialogSuccess()
                }, { error -> view.showDialogError(error.message!!) })
        )
    }

    fun checkInputs(name: String, phone: String) {
        view.enableSaveButton(
            name.isNotEmpty() &&
                    name.length > NAME_LENGHT_MIN &&
                    phone.isNotEmpty() &&
                    phone.length > PHONE_LENGHT_MIN
        )
    }

    override fun attach() {
        compositeDisposable.clear()
    }

    companion object {
        private const val NAME_LENGHT_MIN = 4
        private const val PHONE_LENGHT_MIN = 7
    }
}