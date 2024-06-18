package Com.Project.Service;

import Com.Project.Entity.Project;
import Com.Project.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(int id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(int id, Project projectDetails) {
        Optional<Project> projectOptional = projectRepository.findById(id);

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.setProjectName(projectDetails.getProjectName());
            project.setStart_Date(projectDetails.getStart_Date());
            project.setEnd_Date(projectDetails.getEnd_Date());
            project.setPriority(projectDetails.getPriority());
            project.setBudget(projectDetails.getBudget());
            project.setCreated_Date(projectDetails.getCreated_Date());
            project.setModified_Date(projectDetails.getModified_Date());
            project.setClientId(projectDetails.getClientId());
            return projectRepository.save(project);
        } else {
            throw new RuntimeException("Project not found with id " + id);
        }
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
