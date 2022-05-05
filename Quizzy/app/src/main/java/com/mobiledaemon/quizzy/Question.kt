package com.mobiledaemon.quizzy

import androidx.annotation.StringRes

data class Question(@StringRes val textId : Int, val answer : Boolean)