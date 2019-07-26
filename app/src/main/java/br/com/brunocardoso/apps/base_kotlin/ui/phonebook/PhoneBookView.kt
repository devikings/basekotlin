package br.com.brunocardoso.apps.base_kotlin.ui.phonebook

import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
interface PhoneBookView {
    fun fillPhones(phones: List<Contact>)
    fun showDialogError(error: String)
}