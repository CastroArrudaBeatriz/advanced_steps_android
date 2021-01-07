package com.example.advanced_steps_android

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyBroadcast::class.java)
        intent.putExtra("DATA", "AlarmManager")

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val pendingIntent = PendingIntent.getBroadcast(this, 301, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val time = 3 * 1000

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis().plus(time) ,pendingIntent)
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}