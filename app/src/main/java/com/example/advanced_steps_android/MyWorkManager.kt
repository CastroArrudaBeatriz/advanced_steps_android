package com.example.advanced_steps_android

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorkManager(context: Context, workerParameters: WorkerParameters):
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        Log.d("BAC","Sou um log no workmanager")
        return Result.success()
    }
}