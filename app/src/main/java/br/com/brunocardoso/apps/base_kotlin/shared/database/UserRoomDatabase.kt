package br.com.brunocardoso.apps.base_kotlin.shared.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.brunocardoso.apps.base_kotlin.shared.dao.ContactDao
import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact

/**
 * @author Bruno Cardoso on 23/07/2019.
 */
@Database(entities = [Contact::class], version = 7)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract fun ContactDao(): ContactDao

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
                    "contact_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}