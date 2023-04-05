package com.svax.singleliveevent

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var event = SingleLiveEvent<String>() //Created an instance of it.
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.mButton)
        button.setOnClickListener {
            count++
            event.postValue("Event triggered $count") //triggered the event to listen the updates.
        }

        event.observe(this) { string ->
            //Observing the event, for now in same activity. This can be observed anywhere in the project, and only active observer will get triggered.
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
        }
    }
}