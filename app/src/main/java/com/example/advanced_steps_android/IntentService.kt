package com.example.advanced_steps_android

import android.app.IntentService
import android.content.Intent
import android.util.Log
import android.widget.Toast

class IntentService: IntentService("IntentService") {
    override fun onHandleIntent(intent: Intent?) {
//        val message = intent?.getStringExtra("text")
//        Toast.makeText(applicationContext, "Extra do servico $message", Toast.LENGTH_LONG).show()

        try {
            Log.d("BAC", "antes de dormir no intent service")
            Thread.sleep(5000)
            Log.d("BAC", "Acordei!!! no intent service")
        }catch (e: InterruptedException){
            Thread.currentThread().interrupt()
        }
    }

}