package app.hiennv.moneyfowardtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Articles(
        @SerializedName("articles")
        @Expose
        var articles: List<Article>? = null)