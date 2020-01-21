package ru.itis.almaz.samokatus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tickets.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // для выбора темы закомментировать одну из следующих строчек
        setTheme(R.style.AppTheme)
//        setTheme(R.style.SecondaryTheme)

        // для выбора layout раскомментировать одну из следующих строчек
//        setContentView(R.layout.activity_main)
//        setContentView(R.layout.activity_details)
        setContentView(R.layout.activity_tickets)

        // Рекуклер для activity_main
//        rv_money_items.layoutManager = LinearLayoutManager(this)
//        val adapter = MoneyItemAdapter { }
//        adapter.submitList(
//                mutableListOf(
//                        MoneyItem("Кино", 1000, 0),
//                        MoneyItem("Игры", 2000, 1),
//                        MoneyItem("Книги", 1000, 2),
//                        MoneyItem("Android", 228, 3),
//                        MoneyItem("Android на две строки надо бы вывести было бы здорово", 1231, 4),
//                        MoneyItem("Кино", 2000, 5)
//                )
//        )
//        rv_money_items.adapter = adapter

        // рекуклер для activity_tickets
        rv_tickets.layoutManager = LinearLayoutManager(this)
        val adapter = TicketsAdapter {  }
        adapter.submitList(
            mutableListOf(
                TicketItem(
                    "Круиз с безвиззовой\nАнглией – 259€",
                    "7 дней в апреле 2019 года - vandrouki"
                ),
                TicketItem(
                    "Круиз с безвиззовой\nАнглией – 259€",
                    "7 дней в апреле 2019 года - vandrouki"
                ),
                TicketItem(
                    "Круиз с безвиззовой\nАнглией – 259€",
                    "7 дней в апреле 2019 года - vandrouki"
                ),
                TicketItem(
                    "Круиз с безвиззовой\nАнглией – 259€",
                    "7 дней в апреле 2019 года - vandrouki"
                )
                )
        )
        rv_tickets.adapter = adapter
    }
}
