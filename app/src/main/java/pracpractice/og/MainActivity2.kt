package pracpractice.og

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var txtDate: EditText
    private lateinit var txtMorningTime: EditText
    private lateinit var txtAfternoonTime: EditText
    private lateinit var txtNotes: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonNext: Button
    private lateinit var tvMessage: TextView
private val dateArray = mutableListOf<Float>()
    private val timeArrayMorning = mutableListOf<Float>()
    private val timeArrayAfternoon = mutableListOf<Float>()
    private val notesArray = mutableListOf<Float>()



    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txtDate = findViewById(R.id.txtDate)
        txtMorningTime = findViewById(R.id.txtMorningTime)
        txtAfternoonTime = findViewById(R.id.txtAfternoonTime)
        txtNotes = findViewById(R.id.txtNotes)
        buttonSave = findViewById(R.id.buttonSave)
        buttonClear = findViewById(R.id.buttonClear)
        buttonNext = findViewById(R.id.buttonNext)
        tvMessage = findViewById(R.id.tvMessage)





            buttonClear.setOnClickListener {
            txtDate.setText("")
            txtMorningTime.setText("")
            txtAfternoonTime.setText("")
            txtNotes.setText("")

        }
        buttonSave.setOnClickListener {
            val screenTimeDate= txtDate.text.toString()
            val screenTimeMorning = txtMorningTime.text.toString()
            val screenTimeAfternoon = txtAfternoonTime.text.toString()
            val screenTimeNote = txtNotes.text.toString()

            if (dateArray.isNotEmpty() && timeArrayAfternoon.isNotEmpty()&& timeArrayAfternoon.isNotEmpty()) {
                try {
                    dateArray.add(screenTimeDate.toFloat())
                    timeArrayMorning.add(screenTimeMorning.toFloat())
        timeArrayAfternoon.add(screenTimeAfternoon.toFloat())
        notesArray.add(screenTimeNote.toFloat())
        txtDate.text.clear()
        txtMorningTime.text.clear()
        txtAfternoonTime.text.clear()
        txtNotes.text.clear()
    }catch (e: NumberFormatException){
       tvMessage.text = "please enter a valid un"
    }    }
            else{
    tvMessage.text = "Input cannot be empty"
    }
}

        buttonNext.setOnClickListener {

                val intent = Intent(this, DetailViewActivity::class.java).apply {
                    intent.putExtra("dateArray", dateArray.toFloatArray())
                    intent.putExtra("timeArrayMorning", timeArrayMorning.toFloatArray())
                    intent.putExtra("timeArrayAfternoon", timeArrayAfternoon.toFloatArray())
                    intent.putExtra("notesArray", notesArray.toFloatArray())
                    startActivity(intent)
                }
                startActivity(intent)

        }
    }
}