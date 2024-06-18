package Com.Project.Service;

import java.util.List;
import java.util.Optional;

import Com.Project.Entity.ProjectMember;

public interface ProjectMemberService {
    List<ProjectMember> getAllProjectMembers();
    Optional<ProjectMember> getProjectMemberById(Long id);
    ProjectMember addProjectMember(ProjectMember projectMember);
    ProjectMember updateProjectMember(Long id, ProjectMember projectMemberDetails);
    void deleteProjectMember(Long id);
}
