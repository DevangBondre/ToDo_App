package mai.hu.beast.first.todoapp

import Adapter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mai.hu.beast.first.todoapp.ui.theme.Todo


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodo = findViewById<RecyclerView>(R.id.rvTodo)
        val btAddTask = findViewById<Button>(R.id.btAddTask)
        var todolist =  mutableListOf(
            Todo("Workout " ,false),
            Todo("Read 10 pages", false)
        )
        val adapter = Adapter(todolist)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        btAddTask.setOnClickListener{
            val etTaskAdder = findViewById<EditText>(R.id.etTaskAdder)
            val task = etTaskAdder.text.toString()
            val todo = Todo(task,false)

            todolist.add(todo )
            adapter.notifyItemInserted(todolist.size-1)
        }
    }
}