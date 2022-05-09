package com.mobiledaemon.quizzy

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {
    init{
        Log.d(TAG,"QuizViewModel Instance Created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"QuizViewModel is about to be destroyed")
    }
}