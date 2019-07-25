package br.com.brunocardoso.apps.base_kotlin.ui.phonebook

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.brunocardoso.apps.base_kotlin.shared.base.BasePresenter
import br.com.brunocardoso.apps.base_kotlin.shared.model.Phone
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

    var listPhones: LiveData<List<Phone>> = MutableLiveData<List<Phone>>()

    fun observePhones() = listPhones

    fun addPhone(phone: Phone) {
        compositeDisposable.add(
            repository.save(phone)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view.showDialogSuccess()
                    getPhones()
                }
        )
    }

    fun getPhones() {
        compositeDisposable.add(
            repository.getPhones()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { phones ->
                    listPhones = MutableLiveData(phones)
                    view.fillPhones(phones)
                }
        )
    }

    override fun attach() {
        compositeDisposable.clear()
    }
}