package Com.Project.Controller;

import Com.Project.Entity.ProjectMember;
import Com.Project.Service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project-members")
public class ProjectMemberController {

    @Autowired
    private ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<ProjectMember>> getAllProjectMembers() {
        return ResponseEntity.ok(projectMemberService.getAllProjectMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectMember> getProjectMemberById(@PathVariable Long id) {
        Optional<ProjectMember> projectMember = projectMemberService.getProjectMemberById(id);
        return projectMember.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectMember> addProjectMember(@RequestBody ProjectMember projectMember) {
        try {
            ProjectMember newProjectMember = projectMemberService.addProjectMember(projectMember);
            return ResponseEntity.ok(newProjectMember);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectMember> updateProjectMember(@PathVariable Long id, @RequestBody ProjectMember projectMemberDetails) {
        try {
            ProjectMember updatedProjectMember = projectMemberService.updateProjectMember(id, projectMemberDetails);
            return ResponseEntity.ok(updatedProjectMember);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectMember(@PathVariable Long id) {
        projectMemberService.deleteProjectMember(id);
        return ResponseEntity.ok().build();
    }
}
