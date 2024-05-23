package pracpractice.og

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    private lateinit var editTextDate: EditText
    private lateinit var editTextText1: EditText
    private lateinit var editTextText2: EditText
    private lateinit var editTextText3: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonNext: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        editTextDate = findViewById(R.id.editTextDate)
        editTextText1 = findViewById(R.id.editTextText1)
        editTextText2 = findViewById(R.id.editTextText2)
        editTextText3 = findViewById(R.id.editTextText3)
        buttonSave = findViewById(R.id.buttonSave)
        buttonClear = findViewById(R.id.buttonClear)
        buttonNext = findViewById(R.id.buttonNext)

        val dateArray =arrayOfNulls<String>(7)
        val timeArrayMorning = arrayOfNulls<String>(7)
        val timeArrayAfternoon = arrayOfNulls<String>(7)




        buttonClear.setOnClickListener {
            editTextDate.setText("")
            editTextText1.setText("")
            editTextText2.setText("")
            editTextText3.setText("")

        }
        buttonSave.setOnClickListener {
            dateArray[0] = editTextDate.text.toString()
            timeArrayMorning[0] = editTextText1.text.toString()
            timeArrayAfternoon[0] = editTextText2.text.toString()
            timeArrayAfternoon[0] = editTextText3.text.toString()
        }


        buttonNext.setOnClickListener {
            val intent = Intent(this, DetailViewActivity::class.java)
            startActivity(intent)
        }
    }
}