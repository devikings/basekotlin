package br.com.brunocardoso.apps.base_kotlin.shared.dao

import androidx.room.*
import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(phone: Contact): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(phone: Contact): Completable

    @Delete
    fun delete(phone: Contact): Completable

    @Query("DELETE FROM contact")
    fun deleteAll(): Completable

    @Query("SELECT * FROM contact ORDER BY id DESC")
    fun fetchAll(): Single<List<Contact>>
}