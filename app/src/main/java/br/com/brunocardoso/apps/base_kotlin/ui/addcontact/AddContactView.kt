package br.com.brunocardoso.apps.base_kotlin.ui.addcontact

/**
 * @author Bruno Cardoso on 25/07/2019.
 */
interface AddContactView {
    fun enableSaveButton(enable: Boolean)
    fun showDialogSuccess()
    fun showDialogError(error: String)
}