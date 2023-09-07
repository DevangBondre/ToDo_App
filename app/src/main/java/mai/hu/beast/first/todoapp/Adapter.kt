import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mai.hu.beast.first.todoapp.databinding.ItemTodoBinding
import mai.hu.beast.first.todoapp.ui.theme.Todo

class Adapter(
    private val todos: List<Todo>
) : RecyclerView.Adapter<Adapter.ToDoViewHolder>() {
    inner class ToDoViewHolder( val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.tvTask.text = todo.task
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binding.apply {
            tvTask.text = todos[position].task
            cbDone.isChecked = todos[position].isChecked
        }
    }
}
