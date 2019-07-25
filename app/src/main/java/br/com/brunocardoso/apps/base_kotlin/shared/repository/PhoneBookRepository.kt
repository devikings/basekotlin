package br.com.brunocardoso.apps.base_kotlin.shared.repository

import android.app.Application
import br.com.brunocardoso.apps.base_kotlin.shared.dao.PhoneDao
import br.com.brunocardoso.apps.base_kotlin.shared.database.UserRoomDatabase
import br.com.brunocardoso.apps.base_kotlin.shared.model.Phone
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
class PhoneBookRepository(
    application: Application,
    private val dao: PhoneDao = UserRoomDatabase.getDatabase(application).phoneDao()
) {
    fun save(phone: Phone): Completable = dao.insert(phone)
    fun delete(phone: Phone): Completable = dao.delete(phone)
    fun getPhones(): Single<List<Phone>> = dao.fetchAll()
}