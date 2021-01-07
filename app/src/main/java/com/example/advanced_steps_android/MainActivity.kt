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
    }

    override fun onResume() {
        super.onResume()

        val intentService = Intent(this, IntentService::class.java)
        intentService.putExtra("text", txt_banana.text.toString())
        startService(intentService)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}