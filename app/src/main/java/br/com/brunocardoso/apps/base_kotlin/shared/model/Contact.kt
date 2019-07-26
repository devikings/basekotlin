package br.com.brunocardoso.apps.base_kotlin.shared.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
@Entity(tableName = "Contact")
open class Contact(
    @ColumnInfo(name = "nome") val name: String = "",
    @ColumnInfo(name = "phone") val phone: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}