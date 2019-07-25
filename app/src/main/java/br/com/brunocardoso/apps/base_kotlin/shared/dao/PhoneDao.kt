package br.com.brunocardoso.apps.base_kotlin.shared.dao

import androidx.room.*
import br.com.brunocardoso.apps.base_kotlin.shared.model.Phone
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
@Dao
interface PhoneDao {

    @Insert
    fun insert(phone: Phone): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(phone: Phone): Completable

    @Delete
    fun delete(phone: Phone): Completable

    @Query("DELETE FROM phone")
    fun deleteAll(): Completable

    @Query("SELECT * FROM phone")
    fun fetchAll(): Single<List<Phone>>
}