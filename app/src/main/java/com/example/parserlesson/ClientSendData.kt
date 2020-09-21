package com.example.parserlesson

import android.util.Log

class ClientSendData {
    var commandHear = ""
    var protocolLength = ""
    var operation = ""
    var oprationLength = ""
    var senderType = ""
    var wifiVersion = ""
    var macAddress = ""
    var bandSwitch2_4G = ""
    var SSID_2_4G_Length = 0            //int
    var SSID_2_4G = ""
    var Password_2_4G_Length = 0
    var Password_2_4G = ""
    var bandSwitch_5G = ""
    var SSID_5G_Length = 1              //int
    var SSID_5G = ""                   //由客人輸人的值決定
    var Password_5G_Length = 0
    var Password_5G = ""
    var EAP_Method = ""
    var EAP_Inner_Method = ""
    var EAP_User_ID_Length = ""
    var EAP_User_ID = ""
    var EAP_User_Password_Length = ""
    var EAP_User_Password = ""
    var SG_IP = ""
    var Serial_Number = ""
    var cs = ""
    var commandEnd = ""

    fun combineDataToSend() {
        var sendDataToAdapter = ArrayList<String>()   //宣告它為字串陣列
        sendDataToAdapter.add("55")         // command header
        sendDataToAdapter.add("FE")         // protocol
        sendDataToAdapter.add("71")         // protocol lenght
        sendDataToAdapter.add("FE")         // Operation
        sendDataToAdapter.add("6F")         // Operation length
        sendDataToAdapter.add("01")        // Sendder
        wifiVersion = "313738"             //  wifiVersion -> v1.7.8 (收到313738, 顯示v1.78)
        for (i in 0..(wifiVersion.length / 2) - 1) {
            sendDataToAdapter.add(
                wifiVersion.subSequence(i * 2..i * 2 + 1).toString()
            )     //Wifi-version
        }

        macAddress = "88DA1AF95768"            // macAddress
        for (i in 0..(macAddress.length / 2) - 1) {
            sendDataToAdapter.add(macAddress.subSequence(i * 2..i * 2 + 1).toString())
        }
        bandSwitch2_4G = "01"
        sendDataToAdapter.add(bandSwitch2_4G)           //Band Switch 2.4G , Enable

        sendDataToAdapter.add("0C")            //SSID 2.4G Length
        // SSID_2.4G
        SSID_2_4G = "SportsArt_10"
        for ((i, v) in SSID_2_4G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(SSID_2_4G[i].toInt().toString(16))
            //                 Log.d(TAG, "SSID_2_4G[i]: ${SSID_2_4G[i].toInt().toString(16)}")
        }



        Password_2_4G = "sportsart063840888"                                // Password_2.4G
        for ((i, v) in Password_2_4G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(Password_2_4G[i].toInt().toString(16))
            //          Log.d(TAG, "Password_2_4G[i]: ${Password_2_4G[i].toInt().toString(16)}")
        }

        bandSwitch_5G = "01"
        sendDataToAdapter.add(bandSwitch_5G)           //Band Switch 5G , Enable

        //     SSID_5G = editTextSSID_5G.text.toString            // SSID_5G
        SSID_5G = "SportsArt_10_5G"

        for ((i, v) in SSID_5G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(SSID_5G[i].toInt().toString(16))
            //          Log.d(TAG, "SSID_5G[i]: ${SSID_5G[i].toInt().toString(16)}")
        }

//      Password_5G = editPassword_5G.text.toString
        Password_5G = "00000000"
        for ((i, v) in Password_5G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(Password_5G[i].toInt().toString(16))
            //         Log.d(TAG, "Password_5G[i]: ${Password_5G[i].toInt().toString(16)}")
        }


        //     EAP_Method = spinner                    //Eap method
        EAP_Method = "00"
        sendDataToAdapter.add(EAP_Method)

        //eat inner method
        EAP_Inner_Method = "00"
        sendDataToAdapter.add(EAP_Inner_Method)

        //eap user id length
        EAP_User_ID_Length = "01"
        sendDataToAdapter.add(EAP_User_ID_Length)

        // eap user id
        EAP_User_ID = "SportsArt_EAP"                //使用者輸入
        for ((i, v) in EAP_User_ID.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(EAP_User_ID[i].toInt().toString(16))
            Log.d(TAG, "EAP_User_ID: ${EAP_User_ID[i].toInt().toString(16)}")
        }
        //eap user password length
        EAP_User_Password_Length = "02"
        sendDataToAdapter.add(EAP_User_Password_Length)

        //eap user password
        EAP_User_Password = "00000000"
        for ((i, v) in EAP_User_Password.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(EAP_User_Password[i].toInt().toString(16))
            Log.d(TAG, "EAP_User_Password: ${EAP_User_Password[i].toInt().toString(16)}")
        }
//SGIP
        SG_IP = "192.168.0.14"     //直接送 C0.A8.00.0E

        sendDataToAdapter.add("C0")
        sendDataToAdapter.add("A8")
        sendDataToAdapter.add("00")
        sendDataToAdapter.add("0E")

        //Serial number
        // 0x31 0x32 0x33 0x34 0x35 0x36 0x37(1234567)
        Serial_Number = "1234567"
        sendDataToAdapter.add("31")
        sendDataToAdapter.add("32")
        sendDataToAdapter.add("33")
        sendDataToAdapter.add("34")
        sendDataToAdapter.add("35")
        sendDataToAdapter.add("36")
        sendDataToAdapter.add("37")
        //計算cs
        var totalDataNum = sendDataToAdapter.size
        var v1 = 0
        for (i in 1..totalDataNum - 1) {
            v1 = v1 + sendDataToAdapter[i].toInt(16)       // 16 進制 -> 成10進制計算, 然後成數值
        }
        val v1Hex = v1.toString(16)                     // 10進制 -> 16進制 然後成字串
        cs = v1Hex.subSequence(v1Hex.length - 2, v1Hex.length).toString()
//        Log.d(TAG, "csDec: $v1")
        //       Log.d(TAG, "csHex: $v1Hex")
        //      Log.d(TAG, "cs: $cs")
        //      cs = "77"

        sendDataToAdapter.add(cs)
        commandEnd = "90"                                   //固定
        sendDataToAdapter.add(commandEnd)

// 陣列字串轉一般字串 （最後結果放sk）
        var sk = ""
        for (data in sendDataToAdapter) {
            sk = sk + data
        }
        Log.d(TAG, "sk: $sk")
    }
}