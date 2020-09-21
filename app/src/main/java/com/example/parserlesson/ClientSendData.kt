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
    var SSID_2_4G_Length = ""
    var SSID_2_4G = ""
    var Password_2_4G_Length = ""
    var Password_2_4G = ""
    var bandSwitch_5G = ""
    var SSID_5G_Length = ""
    var SSID_5G = ""                   //由客人輸人的值決定
    var Password_5G_Length = ""
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

        SSID_2_4G = "SportsArt_10"              // SSID_5G_Length
        if (SSID_2_4G.length <= 9) {
            SSID_2_4G_Length = "0" + SSID_2_4G.length
        } else
            SSID_2_4G_Length = SSID_2_4G.length.toString(16)
        Log.d(TAG, "SSID_2.4G length: ${SSID_2_4G_Length} ")
        sendDataToAdapter.add(SSID_2_4G_Length)      //SSID 2.4G Length


        // SSID_2.4G
        SSID_2_4G = "SportsArt_10"
        for ((i, v) in SSID_2_4G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(SSID_2_4G[i].toInt().toString(16))
            //                 Log.d(TAG, "SSID_2_4G[i]: ${SSID_2_4G[i].toInt().toString(16)}")
        }

        Password_2_4G = "sportsart063840888"              // Password_2_4G_Length
        if (Password_2_4G.length <= 9) {
            Password_2_4G_Length = "0" + Password_2_4G.length
        } else
            Password_2_4G_Length  = Password_2_4G.length.toString(16)
        Log.d(TAG, "Password_2_4G: ${Password_2_4G_Length } ")
        sendDataToAdapter.add(Password_2_4G_Length)      //SSID 2.4G Length

        Password_2_4G = "sportsart063840888"                                // Password_2.4G
        for ((i, v) in Password_2_4G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(Password_2_4G[i].toInt().toString(16))
            //          Log.d(TAG, "Password_2_4G[i]: ${Password_2_4G[i].toInt().toString(16)}")
        }

        bandSwitch_5G = "01"
        sendDataToAdapter.add(bandSwitch_5G)           //Band Switch 5G , Enable

        SSID_5G = "SportsArt_10_5G"              // SSID_5G_Length
        if (SSID_5G.length <= 9) {
            SSID_5G_Length = "0" + SSID_5G.length
        } else
            SSID_5G_Length = SSID_5G.length.toString(16)
        Log.d(TAG, "SSID_5G length: ${SSID_5G_Length} ")
        sendDataToAdapter.add(SSID_5G_Length)

        //     SSID_5G = editTextSSID_5G.text.toString            // SSID_5G
        SSID_5G = "SportsArt_10_5G"
        for ((i, v) in SSID_5G.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(SSID_5G[i].toInt().toString(16))
            //          Log.d(TAG, "SSID_5G[i]: ${SSID_5G[i].toInt().toString(16)}")
        }

        Password_5G = "00000000"            // Password_2_4G_Length
        if (Password_5G.length <= 9) {
            Password_5G_Length = "0" + Password_5G.length
        } else
            Password_5G_Length  = Password_5G.length.toString(16)
        Log.d(TAG, "Password_5G: ${Password_5G_Length } ")
        sendDataToAdapter.add(Password_5G_Length)


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

        EAP_User_ID = "SportsArt_EAP"            // EAP user id
        if (EAP_User_ID.length <= 9) {
            EAP_User_ID_Length = "0" + EAP_User_ID.length
        } else
            EAP_User_ID_Length  = EAP_User_ID.length.toString(16)
        Log.d(TAG, "EAP_User_ID_Length: ${EAP_User_ID_Length } ")
        sendDataToAdapter.add(EAP_User_ID_Length)

        // eap user id
        EAP_User_ID = "SportsArt_EAP"                //使用者輸入
        for ((i, v) in EAP_User_ID.withIndex()) {
            //ascii 處理 (因為要送Ascii Code)
            sendDataToAdapter.add(EAP_User_ID[i].toInt().toString(16))
            Log.d(TAG, "EAP_User_ID: ${EAP_User_ID[i].toInt().toString(16)}")
        }


                                                       //eap user password length 長度
        EAP_User_Password = "000000001234567890"
        if (EAP_User_Password.length <= 9) {
            EAP_User_Password_Length = "0" + EAP_User_Password.length
        } else
            EAP_User_Password_Length = EAP_User_Password.length.toString(16)
        Log.d(TAG, "eap user password length: ${EAP_User_Password_Length} ")

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
        //第1個點.
        var index0 = SG_IP.indexOf(".")
 //       Log.d(TAG, "inedx0: ${index0}")
        var index0v = SG_IP.subSequence(0,index0).toString().toInt().toString(16)
         Log.d(TAG, "index0v: $index0v")    //192 -> c0
        when(index0v)
        {
            in "0".."9","a","b","c","d","e","f" -> { index0v = "0" + index0v  }
            else -> {}
        }

//第2個點.
        var index1 = SG_IP.indexOf(".",index0+1)
 //       Log.d(TAG, "inedx1: ${index1}")
        var index1v = SG_IP.subSequence(index0+1,index1).toString().toInt().toString(16)
        Log.d(TAG, "index1v: $index1v")
        when(index1v)
        {
            in "0".."9","a","b","c","d","e","f" -> { index1v = "0" + index1v  }
            else -> {}
        }

//第3個點.
        var index2 = SG_IP.indexOf(".",index1+1)
 //       Log.d(TAG, "inedx2: ${index2}")
        var index2v = SG_IP.subSequence(index1+1,index2).toString().toInt().toString(16)
        Log.d(TAG, "index2v: $index2v")
        when(index2v)
        {
            in "0".."9","a","b","c","d","e","f"-> { index2v = "0" + index2v  }
            else -> {}
        }

// 最後值
        var index3 = SG_IP.length
  //      Log.d(TAG, "inedx3: ${index3}")
        var index3v = SG_IP.subSequence(index2+1,index3).toString().toInt().toString(16)
        Log.d(TAG, "index3v: $index3v")
        when(index3v)
        {
            in "0".."9","a","b","c","d","e","f" -> { index3v = "0" + index3v  }
            else -> {}
        }


        sendDataToAdapter.add(index0v)
        sendDataToAdapter.add(index1v)
        sendDataToAdapter.add(index2v)
        sendDataToAdapter.add(index3v)

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