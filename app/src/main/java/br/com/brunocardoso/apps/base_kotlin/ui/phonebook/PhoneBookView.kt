package br.com.brunocardoso.apps.base_kotlin.ui.phonebook

import br.com.brunocardoso.apps.base_kotlin.shared.model.Phone

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
interface PhoneBookView {
    fun fillPhones(phones: List<Phone>)
    fun showDialogSuccess()
}