package com.example.advanced_steps_android

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcast: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val data = intent?.getStringExtra("DATA")
       Toast.makeText(context, "Eu sou o MyBroadcast executando ... $data", Toast.LENGTH_LONG).show()
    }
}