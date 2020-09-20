package com.sudanix.contactlist.commons

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

inline fun Fragment.snack(
    @StringRes messageRes: Int,
    length: Int = Snackbar.LENGTH_LONG,
    f: Snackbar.() -> Unit = { }
) {
    snack(resources.getString(messageRes), length, f)
}

inline fun Fragment.snack(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
    f: Snackbar.() -> Unit = { }
) {
    val snack = Snackbar.make(this.view!!, message, length)
    snack.f()
    snack.show()
}