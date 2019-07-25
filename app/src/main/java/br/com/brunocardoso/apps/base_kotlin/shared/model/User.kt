package br.com.brunocardoso.apps.base_kotlin.shared.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Bruno Cardoso on 23/07/2019.
 */
@Entity(tableName = "User")
open class User(
    @PrimaryKey @ColumnInfo(name = "id") val id: String = "",
    @ColumnInfo(name = "nome") val nome: String = "",
    @ColumnInfo(name = "email") val email: String = "",
    @ColumnInfo(name = "telefone") val telefone: String = ""
)