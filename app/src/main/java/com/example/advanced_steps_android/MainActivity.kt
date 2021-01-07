package com.example.advanced_steps_android

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
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val myWorkManager = OneTimeWorkRequest.Builder(MyWorkManager::class.java).build()
        val workManager = WorkManager.getInstance(this)

        workManager.enqueue(myWorkManager)

        workManager.getWorkInfoByIdLiveData(myWorkManager.id).observe(this, androidx.lifecycle.Observer {
            if(it.state.isFinished){
                Log.d("BAC", "WorkManager executado")
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}