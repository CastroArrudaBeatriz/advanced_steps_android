package com.example.advanced_steps_android

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val MY_ACTION = "android.intent.action.MY_ACTION_BASE"
        const val MY_CATEGORY = "android.intent.category.MY_CATEGORY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_explicity_intent.setOnClickListener {
            print("Passou aqui no listener")
            val intentFilter = Intent(this, ActivityFilter::class.java)
            startActivity(intentFilter)
        }

        button_implicity_intent_action.setOnClickListener {
            val intent = Intent().apply {
                action = MY_ACTION
            }

            if(intent.resolveActivity(packageManager) != null) startActivity(intent)
        }

        button_implicity_intent_action_category.setOnClickListener {
            val intent = Intent().apply {
                action = MY_ACTION
                addCategory(MY_CATEGORY)
            }

            if(intent.resolveActivity(packageManager) != null) startActivity(intent)
        }

        button_open_page.setOnClickListener {
            val intentPage = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/CastroArrudaBeatriz"))
            startActivity(intentPage)
        }

        button_make_call.setOnClickListener {
            val intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:81997867875"))
            startActivity(intentCall)
        }

        button_create_alarm.setOnClickListener {
            val intentAlarm = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "Acordar")
                putExtra(AlarmClock.EXTRA_HOUR, 8)
                putExtra(AlarmClock.EXTRA_MINUTES, 30)
                putExtra(AlarmClock.EXTRA_DAYS,
                    arrayListOf(Calendar.MONDAY, Calendar.THURSDAY, Calendar.WEDNESDAY, Calendar.TUESDAY, Calendar.FRIDAY))
            }
            startActivity(intentAlarm)
        }
    }
}