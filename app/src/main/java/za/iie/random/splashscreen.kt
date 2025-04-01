package za.iie.random

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splashscreen<TextView> : AppCompatActivity() {
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
        val textDisplay = findViewById<TextView>(R.id.textView)

        buttonSearch.setOnClickListener {
            val timeOfDay = editText.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()) {
                "morning" -> "HAVE A HEALTHY BREAKFAST"
                "mid-morning" -> "HAVE SOMETHING LIGHT TO CONTINUE YOUR DAY"
                "afternoon" -> "HAVE SOMETHING TO FILL YOU UP FOR THE AFTERNOON"
                "mid-afternoon" -> "GET YOURSELF A SNACK AND A DRINK TO HOLD UP"
                "dinner" -> "ENJOY A HOT MEAL WITH YOUR FAM BAM! "
                else -> "PLEASE ENTER CORRECT SPELLING."
            }
            textDisplay.text = suggestion
        }

        buttonReset.setOnClickListener {
            editText.text.clear()
            textDisplay.text = ""
        }
    }
    }
}