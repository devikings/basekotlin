package br.com.brunocardoso.apps.base_kotlin.shared.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.brunocardoso.apps.base_kotlin.shared.dao.PhoneDao
import br.com.brunocardoso.apps.base_kotlin.shared.dao.UserDao
import br.com.brunocardoso.apps.base_kotlin.shared.model.Phone
import br.com.brunocardoso.apps.base_kotlin.shared.model.User

/**
 * @author Bruno Cardoso on 23/07/2019.
 */
@Database(entities = [User::class, Phone::class], version = 3)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun phoneDao(): PhoneDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(
            context: Context
        ): UserRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "User_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}