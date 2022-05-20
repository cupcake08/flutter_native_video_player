package com.example.exoplayer

import android.content.Intent
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "ankit.flutter.dev/video"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegister.registerGeneratedPlugins(FlutterEngine(this))
        flutterEngine?.dartExecutor?.let {
            MethodChannel(it,CHANNEL).setMethodCallHandler {
            call,_ ->
                if(call.method.equals("playVideo")){
                    goToVideoActivity()
                }
        }
        }
    }

    private fun goToVideoActivity() {
        startActivity(Intent(this,VideoActivity::class.java))
    }
}
