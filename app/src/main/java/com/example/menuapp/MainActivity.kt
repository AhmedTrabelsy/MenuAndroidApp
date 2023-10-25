package com.example.menuapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var constraintLayout: ConstraintLayout
    lateinit var clearButton: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.colors)
        constraintLayout = findViewById(R.id.mainPage)
        clearButton = findViewById(R.id.clearButton)
        registerForContextMenu(textView)

        clearButton.setOnClickListener{
            Toast.makeText(applicationContext, "Background set to default !", Toast.LENGTH_SHORT).show()
            constraintLayout.setBackgroundColor(Color.BLACK)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id. menu_search -> {
                Toast.makeText(applicationContext, "Menu search sélectionné", Toast.LENGTH_SHORT).show()
                true
            }
            R.id. exit -> {
                Toast.makeText(applicationContext, "Quitter l'application !", Toast.LENGTH_SHORT).show()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Choose a color")
        menu?.setHeaderIcon(R.drawable.ic_colors)
        menuInflater.inflate(R.menu.contextmenu, menu)    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.yellow -> {
                constraintLayout.setBackgroundColor(Color.YELLOW)
                Toast.makeText(applicationContext, "Background set to YELLOW !", Toast.LENGTH_SHORT).show()
            }
            R.id.red -> {
                constraintLayout.setBackgroundColor(Color.RED)
                Toast.makeText(applicationContext, "Background set to RED !", Toast.LENGTH_SHORT).show()
            }
            R.id.blue -> {
                constraintLayout.setBackgroundColor(Color.BLUE)
                Toast.makeText(applicationContext, "Background set to BLUE !", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}