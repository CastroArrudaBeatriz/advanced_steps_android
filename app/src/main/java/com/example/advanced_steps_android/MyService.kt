package com.example.advanced_steps_android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.*
import kotlin.concurrent.timerTask

class MyService : Service() {

    private lateinit var timerTask: TimerTask
    private val timer = Timer()
    private var count = 0

    override fun onCreate() {
        Log.d("BAC", "OnCreate Service")
        super.onCreate()
        timerTask = timerTask{
            count++
            Log.d("TIMER", count.toString())
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.d("BAC", "OnBind Service")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("BAC", "OnStartCommand Service")
        timer.schedule(timerTask, 1000, 500)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("BAC", "OnDestroy Service")
        super.onDestroy()
        timer.cancel()
    }
}