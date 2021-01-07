package com.example.advanced_steps_android

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_start_service.setOnClickListener {
            val intentService = Intent(this, MyService::class.java)
            startService(intentService)
        }

        button_stop_service.setOnClickListener {
            val intentService = Intent(this, MyService::class.java)
            stopService(intentService)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}