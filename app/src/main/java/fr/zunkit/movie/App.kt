package fr.zunkit.movie

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import fr.zunkit.movie.config.injectFeature
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    companion object {
        val channel = Channel<Int>(Channel.UNLIMITED)
        val publisher = ConflatedBroadcastChannel<String>()
    }

    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@App) }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        CoroutineScope(Dispatchers.IO).launch {
            infiniteLoop(0)
        }
        CoroutineScope(Dispatchers.IO).launch {
            infiniteLoop2(0)
        }
    }

    private suspend fun infiniteLoop2(i: Int) {
        delay(1000)
        publisher.send("Coucou $i")
        infiniteLoop2(i+1)
    }

    private suspend fun infiniteLoop(i: Int) {
        delay(1000)
        channel.send(i)
        infiniteLoop(i+1)
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
        setContentView(R.layout.activity_main)
    }
}

