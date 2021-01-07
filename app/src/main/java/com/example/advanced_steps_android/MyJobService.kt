package com.example.advanced_steps_android

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobService: JobService() {

    private var isWorking = false

    override fun onStartJob(jobParameters: JobParameters?): Boolean {
        isWorking = true

        Thread{
            Log.d("BAC", "iniciar execuçao job service")

            Thread.sleep(10 * 1000)

            Log.d("BAC", "executou o sono")
            isWorking = false
            jobFinished(jobParameters, false)
        }.start()

        return isWorking
    }

    override fun onStopJob(jobParameters: JobParameters?): Boolean {
        return isWorking
    }

}