package com.erimkorkmaz.catchthekenny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var score = 0
    var handler = Handler()
    var runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = GridLayoutManager(this, 3, RecyclerView.VERTICAL,false)
        hideImages()

        object : CountDownTimer(15900,1000){
            override fun onFinish() {
                text_time.text  = "Time : 0"

                handler.removeCallbacks(runnable)

                    recyclerView.visibility = View.GONE

                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart the Game")
                alert.setPositiveButton("Yes") {dialogInterface, i ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No") {dialogInterface, i ->
                    Toast.makeText(this@MainActivity,"Game Over", Toast.LENGTH_LONG).show()
                }

                alert.show()
            }

            override fun onTick(p0: Long) {
                text_time.text = "Time : " + p0/1000
            }

        }.start()
    }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {
                val random = Random()
                val randomIndex = random.nextInt(9)
                val adapter1 = Adapter(randomIndex)
                recyclerView.visibility = View.VISIBLE
                recyclerView.adapter = adapter1
                handler.postDelayed(runnable,400)
            }
        }
        handler.post(runnable)

    }

    fun increaseScore(view:View){
        score++
        text_score.text = "Score : $score"
    }

}
