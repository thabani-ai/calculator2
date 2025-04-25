package vcmsa.ci.calculator2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var tvInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }

    // Method to handle number buttons
    fun onDigit(view: View) {
        // Ensure the 'view' is a Button, and then use it
        val button = view as Button
        tvInput.append(button.text)  // Append the text from the button
    }

    // Method to handle operator buttons (+, -, *, /)
    fun onOperator(view: View) {
        // Ensure the 'view' is a Button, and then use it
        val button = view as Button
        tvInput.append(" ${button.text} ")  // Append operator with spaces for clarity
    }

    // Method to handle the equal button (=)
    @SuppressLint("SetTextI18n")
    fun onEqual() {
        try {
            val result = ExpressionBuilder(tvInput.text.toString()).build().evaluate()
            tvInput.text = result.toString()  // Display result in the input field
        } catch (e: Exception) {
            tvInput.text = "Error"  // Display error if the expression is invalid
        }
    }

    // Method to handle clear button (C)
    fun onClear() {
        tvInput.text = ""  // Clear the input field
    }
}