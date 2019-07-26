package br.com.brunocardoso.apps.base_kotlin.shared.repository

import android.app.Application
import br.com.brunocardoso.apps.base_kotlin.shared.dao.ContactDao
import br.com.brunocardoso.apps.base_kotlin.shared.database.UserRoomDatabase
import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
class PhoneBookRepository(
    application: Application,
    private val dao: ContactDao = UserRoomDatabase.getDatabase(application).ContactDao()
) {
    fun save(contact: Contact): Completable = dao.insert(contact)
    fun delete(contact: Contact): Completable = dao.delete(contact)
    fun getcontacts(): Single<List<Contact>> = dao.fetchAll()
}