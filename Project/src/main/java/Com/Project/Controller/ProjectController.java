package Com.Project.Controller;

import Com.Project.Entity.Project;
import Com.Project.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id) {
        Optional<Project> project = projectService.getProjectById(id);

        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project projectDetails) {
        try {
            Project updatedProject = projectService.updateProject(id, projectDetails);
            return ResponseEntity.ok(updatedProject);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
