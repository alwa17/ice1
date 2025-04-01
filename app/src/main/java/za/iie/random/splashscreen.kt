package za.iie.random

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editText = findViewById<EditText>(R.id.editText)
        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textDisplay = findViewById<TextView>(R.id.textDisplay)

        buttonSearch.setOnClickListener {
            val timeOfDay = editText.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()) {
                "morning" -> "HAVE A HEALTHY BREAKFAST TO START YOUR DAY!"
                "mid-morning" -> "GRAB SOMETHING LIGHT TO KEEP UP."
                "afternoon" -> "GET YOURSELF SOMETHING TO FILL YOU UP FOR THE REST OF THE DAY."
                "mid-afternoon" -> "GRAB A SNACK AND SOMETHING TO DRINK."
                "dinner" -> "ENJOY A HOT MEAL BEFORE GOING BED."
                else -> "PLEASE ENTER CORRECT SPELLING TO RUN APP."
            }
            textDisplay.text = suggestion
        }

        buttonReset.setOnClickListener {
            editText.text.clear()
            textDisplay.text = ""
        }
    }
}