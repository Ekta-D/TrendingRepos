package com.android.revolut.myapplication.model

data class TrendingRepos(val author:String,val name :String,
                         val avatar: String, val url:String,
                         val language:String, val languageColor:String,
                         val stars:Int, val folks : Int,
                         val currentPeriodStars:Int) {
}