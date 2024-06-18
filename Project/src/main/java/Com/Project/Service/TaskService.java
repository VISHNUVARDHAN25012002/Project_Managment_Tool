package Com.Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Project.Entity.Task;
//import Com.Project.Entity.Task
import Com.Project.Repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	// Create or update a task
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	// Retrieve all tasks
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	// Retrieve a task by ID
	public Optional<Task> getTaskById(int id) {
		return taskRepository.findById(id);
	}

	// Delete a task by ID
	public void deleteTask(int id) {
		taskRepository.deleteById(id);
	}
}
