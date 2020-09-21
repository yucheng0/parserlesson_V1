package com.example.parserlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
// 55 FE 71 FE 6F 00 31 37 38 88 DA 1A F9 57 68 01 0C 53 70 6f 72 74 73 61 72 74 5f 31 31 12 73 70 6f 72 74 73 61 72 74 30 36 33 38 34 30 38 38 38 01 0F
//53 70 6f 72 74 73 61 72 74 5f 31 31 5f 35 47 08 30 30 30 30 30 30 30 30 00 00 0C 53 70 6f 72 74 73 41 72 74 45 41 50 0F 73 61 2e 65 61 70 30 36 33 38
//34 30 38 38 38 C0 A8 00 0E 0x31 0x32 0x33 0x34 0x35 0x36 0x37 CS 90

val TAG = "myTag"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clientSendData = ClientSendData()
        clientSendData.combineDataToSend()
      }
}

   
    
