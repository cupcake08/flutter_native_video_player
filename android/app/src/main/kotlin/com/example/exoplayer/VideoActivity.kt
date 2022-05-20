package com.example.exoplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exoplayer.databinding.VideoLayoutBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class VideoActivity : AppCompatActivity() {

    private var _player:ExoPlayer? = null

    private lateinit var binding : VideoLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VideoLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        exoPlayerSetup()
    }

    private fun exoPlayerSetup() {
        var player:ExoPlayer = ExoPlayer.Builder(this).build()
        _player = player
//        player.release()
        val mediaItem:MediaItem = MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4")
        val playerView = findViewById<StyledPlayerView>(R.id.exoplayerView)

        playerView.player = _player
        _player!!.addMediaItem(mediaItem)
        _player!!.prepare()
        _player!!.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        _player!!.release()
    }
}