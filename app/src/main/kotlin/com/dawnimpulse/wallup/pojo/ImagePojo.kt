package com.dawnimpulse.wallup.pojo

import com.google.gson.annotations.SerializedName

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

/**
 * @author Saksham
 *
 * @note Last Branch Update - master
 * @note Created on 2018-05-13 by Saksham
 *
 * @note Updates :
 */
data class ImagePojo(
        @SerializedName("id") val id: String,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("width") val width: String,
        @SerializedName("height") val height: String,
        @SerializedName("color") val color: String?,
        @SerializedName("urls") val urls: Urls,
        @SerializedName("links") val links: Links,
        @SerializedName("likes") val likes: Int,
        @SerializedName("user") val user: UserPojoRefined
)

data class Urls(
        @SerializedName("raw") val raw: String,
        @SerializedName("full") val full: String,
        @SerializedName("thumb") val thumb: String
)

data class Links(
        @SerializedName("self") val self: String,
        @SerializedName("html") val html: String,
        @SerializedName("download") val download: String,
        @SerializedName("download_location") val download_location: String
)