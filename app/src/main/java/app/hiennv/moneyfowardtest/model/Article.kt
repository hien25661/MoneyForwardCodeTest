package app.hiennv.moneyfowardtest.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Article(
        @SerializedName("title")
        @Expose
        var title: String? = null,
        @SerializedName("pubDate")
        @Expose
        var pubDate: String? = null,

        @SerializedName("dc:creator")
        @Expose
        var creator: String? = null,

        @SerializedName("category")
        @Expose
        var categories: List<String>? = null,

        @SerializedName("description")
        @Expose
        var description: String? = null,

        @SerializedName("image")
        @Expose
        var image: String? = null,

        @SerializedName("detail")
        @Expose
        var detail: String? = null)
    : Parcelable {
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(title)
        dest?.writeString(pubDate)
        dest?.writeString(creator)
        dest?.writeStringList(categories)
        dest?.writeString(description)
        dest?.writeString(image)
        dest?.writeString(detail)
    }

    override fun describeContents(): Int {
        return 0
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}

