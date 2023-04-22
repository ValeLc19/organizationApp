package com.example.organizationapp

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kizitonwose.calendar.core.atStartOfMonth
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.kizitonwose.calendar.view.ViewContainer
import com.kizitonwose.calendar.view.WeekCalendarView
import com.kizitonwose.calendar.view.WeekDayBinder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.util.*

class TaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_task_fragment, container, false)

        val weekCalendarView = view.findViewById<WeekCalendarView>(R.id.week_calendar_view)
        val yearTextview = view.findViewById<TextView>(R.id.year_textview)
       // val monthTextview = view.findViewById<TextView>(R.id.month_name_textview)

        //SimpleDateFormat es para definir el formato que tu necesitas
        var dateFormat: DateFormat = SimpleDateFormat("MMMM")

        //Date() Te da el dia de hoy Ej:05/04/2023 5:12PM
        val date = Date()

        // dateFormat es la variable que ya definimos arriba con el formato que quieres y format() va a tomar una variable tipo Date y transformarla en el formato que definimos.
        //val formattedMonth = dateFormat.format(date)

        //al textview del month se le asigna el valor de la fecha ya formateada
        //monthTextview.text = formattedMonth

        //la variable dateFormat que ya tenemos arriba se redefinio con el formato que necesitamos para que nos de ahora solo el año
        dateFormat = SimpleDateFormat("YYYY")

        // dateFormat es la variable ya redefinida con el formato año, format() va a tomar una variable tipo Date y transformarla para que al asignarla a la variable
        //yearTexview ahora solo regrese el año
        val formattedYear = dateFormat.format(date)

        //al textview del year se le asigna el valor de la fecha ya formateada
        yearTextview.text = formattedYear

        weekCalendarView.dayBinder = object : WeekDayBinder<DayViewContainer> {
            // Called only when a new container is needed.
            override fun create(view: View) = DayViewContainer(view)

            // Called every time we need to reuse a container.
            override fun bind(
                container: DayViewContainer,
                data: com.kizitonwose.calendar.core.WeekDay
            ) {
                container.dayNumberTextView.text = data.date.dayOfMonth.toString()
                if (data.date.dayOfMonth == LocalDate.now().dayOfMonth) {
                    container.dayNumberTextView.textSize = 40f
                    container.dayNumberTextView.setTypeface(null,Typeface.BOLD)
                } else {
                    container.dayNumberTextView.textSize = 22f
                }

                container.dayNameTextView.text = data.date.dayOfWeek.name.subSequence(0, 3)
            }
        }


        val currentDate = LocalDate.now()
        val currentMonth = YearMonth.now()
        val startDate = currentMonth.minusMonths(100).atStartOfMonth() // Adjust as needed
        val endDate = currentMonth.plusMonths(100).atEndOfMonth()  // Adjust as needed
        val firstDayOfWeek =  currentDate.dayOfWeek.minus(3)//firstDayOfWeekFromLocale().minus(2)

        weekCalendarView.setup(startDate, endDate, firstDayOfWeek)
        weekCalendarView.scrollToDate(currentDate)

        return view
    }
}

class DayViewContainer(view: View) : ViewContainer(view) {
    val dayNumberTextView = view.findViewById<TextView>(R.id.day_number_textview)
    val dayNameTextView = view.findViewById<TextView>(R.id.day_name_textview)
    val monthNameTextView = view.findViewById<TextView>(R.id.month_name_textview)
}