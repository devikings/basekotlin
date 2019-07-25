package br.com.brunocardoso.apps.base_kotlin.shared.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Bruno Cardoso on 24/07/2019.
 */

@Entity(tableName = "Phone")
open class Phone(
    @ColumnInfo(name = "nome") val name: String = "",
    @ColumnInfo(name = "phone") val phone: String = ""
) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = ""
}