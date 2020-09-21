package com.example.parserlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

val TAG = "myTag"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var commandHear = "55"
        var protocolLength = "04"
        var operation = "ff"
        var oprationLength = "6f"
        var senderType = "00"
        var wifiVersion = "00"
        var macAddress = ""
        var bandSwitch2_4G = "00"
        var SSID_2_4G_Length = 1            //int
        var SSID_2_4G = "00"
        var Password_2_4G_Length = 0
        var Password_2_4G = "sportsart063840888"

        var BandSwitch_5G = "00"
        var SSID_5G_Length = 1              //int
        var SSID_5G = "SportsArt_10_5G"   //由客人輸人的值決定
        var Password_5G_Length = 0
        var Password_5G = "00000000"

        var EAP_Method = "00"
        var EAP_Inner_Method = "00"
        var EAP_User_ID_Length = "00"
        var EAP_User_ID = "00"
        var EAP_User_Password_Length = "00"
        var EAP_User_Password = "00"
        var SG_IP = "00"
        var Serial_Number = "00"
        var cs = "9f"
        var commandEnd = "90"

        //Test
        val s = "0"
        var s1 = s.toInt(16).toString()
        Log.d(TAG, "s1: $s1")


        SSID_2_4G = "SportsArt_10"
        SSID_2_4G_Length = SSID_2_4G.length
        var SSID_2_4G_ByteArray = ByteArray(SSID_2_4G_Length)

        //
        Password_2_4G = "sportsart063840888"
        Password_2_4G_Length = Password_2_4G.length
        var Password_2_4G_ByteArray = ByteArray(Password_2_4G_Length)

        //
        Password_5G = "00000000"
        Password_5G_Length = Password_5G.length
        var Password_5G_ByteArray = ByteArray(Password_5G_Length)


        //
        SSID_5G = "SportsArt_10_5G"
        SSID_5G_Length = SSID_5G.length         // 取大小
        var SSID_5G_ByteArray = ByteArray(SSID_5G_Length)


        // 合成  (字串轉陣列)
        for ((i, v) in SSID_2_4G.withIndex()) {
            SSID_2_4G_ByteArray[i] = v.toByte()
            Log.d(TAG, "SSID2.4G: $i, $v")
        }


        // 合成  (字串轉陣列)
        for ((i, v) in Password_2_4G.withIndex()) {
            Password_2_4G_ByteArray[i] = v.toByte()
            Log.d(TAG, "Password_2.4G: $i, $v")
        }

// 合成  (字串轉陣列)


//
        for ((i, v) in SSID_5G.withIndex()) {
            SSID_5G_ByteArray[i] = v.toByte()
            Log.d(TAG, "SSID_5G: $i, $v")
        }
//
        for ((i, v) in Password_5G.withIndex()) {
            Password_5G_ByteArray[i] = v.toByte()
            Log.d(TAG, "Password_5G: $i, $v")
        }
//
        var SendDataToAdapter = ArrayList<String>()
        SendDataToAdapter.add("55")
        SendDataToAdapter.add("FE")
        SendDataToAdapter.add("71")
        SendDataToAdapter.add("FE")
        SendDataToAdapter.add("6F")
        SendDataToAdapter.add("01")       //Sendder

        // wifiVersion
        wifiVersion = "313738"
        for (i in 0..(wifiVersion.length / 2) - 1) {
            SendDataToAdapter.add(
                wifiVersion.subSequence(i * 2..i * 2 + 1).toString()
            )     //Wifi-version
        }

        // macAddress
        macAddress = "88DA1AF95768"
        for (i in 0..(macAddress.length / 2) - 1) {
            SendDataToAdapter.add(macAddress.subSequence(i * 2..i * 2 + 1).toString())
        }

        SendDataToAdapter.add("01")    //Band Switch 2.4G , Enable
        SendDataToAdapter.add("01")    //SSID 2.4G Length

// SSID_2.4G
        for ((i, v) in SSID_2_4G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            SendDataToAdapter.add(SSID_2_4G[i].toInt().toString(16))
            //                 Log.d(TAG, "SSID_2_4G[i]: ${SSID_2_4G[i].toInt().toString(16)}")
        }

// Password_2.4G
        for ((i, v) in Password_2_4G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            SendDataToAdapter.add(Password_2_4G[i].toInt().toString(16))
            //          Log.d(TAG, "Password_2_4G[i]: ${Password_2_4G[i].toInt().toString(16)}")
        }

// SSID_5G
        for ((i, v) in SSID_5G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            SendDataToAdapter.add(SSID_5G[i].toInt().toString(16))
            //          Log.d(TAG, "SSID_5G[i]: ${SSID_5G[i].toInt().toString(16)}")
        }

// Password_5G
        for ((i, v) in Password_5G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            SendDataToAdapter.add(Password_5G[i].toInt().toString(16))
            //         Log.d(TAG, "Password_5G[i]: ${Password_5G[i].toInt().toString(16)}")
        }


//Eap method
        SendDataToAdapter.add("00")

        //eat inner method
        SendDataToAdapter.add("00")

        //eap user id length
        SendDataToAdapter.add("01")

        // eap user id
        EAP_User_ID = "SportsArt_EAP"
        for ((i, v) in EAP_User_ID.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            SendDataToAdapter.add(EAP_User_ID[i].toInt().toString(16))
  //          Log.d(TAG, "EAP_User_ID: ${EAP_User_ID[i].toInt().toString(16)}")
        }

        //eap user password length
        SendDataToAdapter.add("02")

        //eap user password
        EAP_User_Password = "00000000"
        for ((i, v) in EAP_User_Password.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            SendDataToAdapter.add(EAP_User_Password[i].toInt().toString(16))
            Log.d(TAG, "EAP_User_Password: ${EAP_User_Password[i].toInt().toString(16)}")
        }
//SGIP
        SG_IP = "192.168.0.14"     //直接送 C0.A8.00.0E

        SendDataToAdapter.add("C0")
        SendDataToAdapter.add("A8")
        SendDataToAdapter.add("00")
        SendDataToAdapter.add("0E")

        //Serial number
       // 0x31 0x32 0x33 0x34 0x35 0x36 0x37(1234567)
        Serial_Number = "1234567"
        SendDataToAdapter.add("31")
        SendDataToAdapter.add("32")
        SendDataToAdapter.add("33")
        SendDataToAdapter.add("34")
        SendDataToAdapter.add("35")
        SendDataToAdapter.add("36")
        SendDataToAdapter.add("37")




        Log.d(TAG, "SendDataToAdapter: $SendDataToAdapter")

        var wifiParameter = "55" +
                "FE" +
                "71" +
                "6F" +
                "01" +
                wifiVersion +
                macAddress +
                bandSwitch2_4G +
                SSID_2_4G_Length +

                SSID_2_4G +
                Password_2_4G_Length +
                Password_2_4G +
                BandSwitch_5G +
                SSID_5G_Length +
                SSID_5G +
                Password_5G_Length +
                Password_5G +
                EAP_Method +
                EAP_Inner_Method +
                EAP_User_ID_Length +
                EAP_User_ID +
                EAP_User_Password_Length +
                EAP_User_Password +
                SG_IP +
                Serial_Number
    }


    //      Log.d(TAG, "onCreate: $k")


}

   
    
