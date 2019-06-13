/**
 * ISC License
 *
 * Copyright 2018-2019, Saksham (DawnImpulse)
 *
 * Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby granted,
 * provided that the above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT,
 * INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
 * WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE
 * OR PERFORMANCE OF THIS SOFTWARE.
 **/
package com.dawnimpulse.wallup.ui.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dawnimpulse.wallup.ui.objects.BannerCollectionObject
import com.dawnimpulse.wallup.utils.handlers.ImageHandler
import kotlinx.android.synthetic.main.inflator_banner_collection.view.*

/**
 * @info -
 *
 * @author - Saksham
 * @note Last Branch Update - master
 *
 * @note Created on 2019-06-12 by Saksham
 * @note Updates :
 */
class BannerCollectionHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val banner = view.bannerColImage
    private val text = view.bannerColText

    fun bind(item: BannerCollectionObject) {
        ImageHandler.setImageImgix(banner, item.image, 720)
        text.text = item.title
    }
}