package Com.Project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Project.Entity.Task;
//import Com.Project.Entity.TaskEntity;
import Com.Project.Service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	// Create a new task
	@PostMapping("/create")
	public Task createTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}

	// Get all tasks
	@GetMapping
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	// Get a task by ID
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable int id) {
		Optional<Task> task = taskService.getTaskById(id);
		if (task.isPresent()) {
			return ResponseEntity.ok(task.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Update a task
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task taskDetails) {
		Optional<Task> task = taskService.getTaskById(id);
		if (task.isPresent()) {
			Task updatedTask = task.get();
			updatedTask.setTitle(taskDetails.getTitle());
			updatedTask.setDescription(taskDetails.getDescription());
			updatedTask.setStatus(taskDetails.getStatus());
			updatedTask.setAssignee(taskDetails.getAssignee());
			updatedTask.setCreated_Date(taskDetails.getCreated_Date());
			updatedTask.setDue_Date(taskDetails.getDue_Date());
			updatedTask.setCompleted_Date(taskDetails.getCompleted_Date());
			taskService.saveTask(updatedTask);
			return ResponseEntity.ok(updatedTask);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete a task
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable int id) {
		if (taskService.getTaskById(id).isPresent()) {
			taskService.deleteTask(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
