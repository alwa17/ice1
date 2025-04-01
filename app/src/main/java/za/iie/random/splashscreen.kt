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
                "morning" -> "Go for a jog or have a healthy breakfast!"
                "mid-morning" -> "Time for a light snack or a short walk."
                "afternoon" -> "A great time to focus on work or studies."
                "mid-afternoon" -> "Have some coffee and refresh yourself!"
                "dinner" -> "Enjoy a nice meal with family or friends."
                else -> "Please enter a valid time of day."
            }
            textDisplay.text = suggestion
        }

        buttonReset.setOnClickListener {
            editText.text.clear()
            textDisplay.text = ""
        }
    }
}