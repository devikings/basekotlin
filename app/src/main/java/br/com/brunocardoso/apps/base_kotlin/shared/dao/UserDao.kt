package br.com.brunocardoso.apps.base_kotlin.shared.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.brunocardoso.apps.base_kotlin.shared.model.User
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author Bruno Cardoso on 23/07/2019.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithCompletable(user: User): Completable

    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user")
    fun getAllPhones(): Single<List<User>>

    @Query("DELETE FROM user")
    fun deleteAll()
}