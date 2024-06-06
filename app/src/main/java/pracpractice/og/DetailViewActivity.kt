package pracpractice.og

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class DetailViewActivity : AppCompatActivity() {

    private lateinit var btn_back : Button
    private lateinit var tv_details : TextView
    private lateinit var tvHoursAM : TextView
    private lateinit var tvHoursPM : TextView
    private lateinit var tvHoursNotes : TextView
    private lateinit var listView : TextView



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)

        btn_back = findViewById(R.id.btn_back)
        tv_details = findViewById(R.id.tv_details)
        tvHoursAM = findViewById(R.id.tvHoursAM)
        tvHoursNotes = findViewById(R.id.tvHoursNotes)


        var dateArray = intent.getFloatArrayExtra("dateArray") ?.toList() ?:emptyList()
        var NotesArray = intent.getStringArrayExtra("noteArray") ?.toList() ?:emptyList()
        var MorningTimeArray = intent.getFloatArrayExtra("timeArrayMorning") ?.toList() ?:emptyList()
        var AfternoonTimeArray =intent.getFloatArrayExtra("timeArrayAfternoon") ?.toList() ?:emptyList()

        val dated = StringBuilder()
        for ((index, date) in  dateArray.withIndex()){
            dated.append("Day ${index + 1}: $date \n")
        }
val hoursAM = StringBuilder()
        for ((index, hours) in  MorningTimeArray.withIndex()){
            hoursAM.append("Day ${index + 1}: $hours \n")
        }
val hoursPM = StringBuilder()
        for ((index, hours) in  AfternoonTimeArray.withIndex()){
            hoursPM.append("Day ${index + 1}: $hours \n")
        }
        val noted = StringBuilder()
        for ((index, note) in  NotesArray.withIndex()){
            noted.append("Day ${index + 1}: $note \n")
        }

        tv_details.text = dated.toString()
        tvHoursAM.text = hoursAM.toString()
        tvHoursPM.text = hoursPM.toString()
        tvHoursNotes.text = noted.toString()

        btn_back.setOnClickListener {
            finish()
        }




    }
}