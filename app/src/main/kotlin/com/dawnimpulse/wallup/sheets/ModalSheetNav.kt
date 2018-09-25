/*
ISC License

Copyright 2018, Saksham (DawnImpulse)

Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby granted,
provided that the above copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT,
INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE
OR PERFORMANCE OF THIS SOFTWARE.*/
package com.dawnimpulse.wallup.sheets

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dawnimpulse.wallup.BuildConfig
import com.dawnimpulse.wallup.R
import com.dawnimpulse.wallup.activities.AboutActivity
import com.dawnimpulse.wallup.activities.CollectionLayoutActivity
import com.dawnimpulse.wallup.activities.GeneralImagesActivity
import com.dawnimpulse.wallup.utils.C
import com.dawnimpulse.wallup.utils.F
import com.dawnimpulse.wallup.utils.RemoteConfig
import kotlinx.android.synthetic.main.bottom_sheet_navigation.*


/**
 * @author Saksham
 *
 * @note Last Branch Update -
 * @note Created on 2018-08-19 by Saksham
 *
 * @note Updates :
 * Saksham - 2018 09 15 - master - update handling
 */
class ModalSheetNav : RoundedBottomSheetDialogFragment(), View.OnClickListener {

    // on create
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet_navigation, container, false);
    }

    // view created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sheetNavRandom.setOnClickListener(this)
        sheetNavFeedback.setOnClickListener(this)
        sheetNavCollection.setOnClickListener(this)
        sheetNavAbout.setOnClickListener(this)

        RemoteConfig.getProductionUpdateValues()?.let {
            if (it.next_version_code > BuildConfig.VERSION_CODE) {
                sheetNavUpdateL.visibility = View.VISIBLE
                sheetNavUpdateL.setOnClickListener(this)
            } else if (it.text_available) {
                sheetNavNextUpdate.visibility = View.VISIBLE
                sheetNavNextUpdate.text = it.text
            }
        }
    }

    // clicked
    override fun onClick(v: View) {
        when (v.id) {
            sheetNavRandom.id -> {
                var intent = Intent(activity, GeneralImagesActivity::class.java)
                intent.putExtra(C.TYPE, C.RANDOM)
                startActivity(intent)
                dismiss()
            }
            sheetNavFeedback.id -> {
                val emailIntent = Intent(android.content.Intent.ACTION_SEND)
                emailIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                emailIntent.type = "vnd.android.cursor.item/email"
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, arrayOf("dawnimpulse@gmail.com"))
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Wallup Feedback  v${BuildConfig.VERSION_NAME}")
                startActivity(Intent.createChooser(emailIntent, "Send mail using..."))
            }
            sheetNavCollection.id -> {
                startActivity(Intent(activity, CollectionLayoutActivity::class.java))
                dismiss()
            }

            sheetNavAbout.id -> {
                startActivity(Intent(activity, AboutActivity::class.java))
                dismiss()
            }

            sheetNavUpdateL.id ->
                F.startWeb(context!!, C.WALLUP_PLAY)
        }
    }
}