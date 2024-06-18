package Com.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Project.Entity.Member;
import Com.Project.Entity.Project;
import Com.Project.Entity.ProjectMember;
import Com.Project.Repository.MemberRepository;
import Com.Project.Repository.ProjectMemberRepository;
import Com.Project.Repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectMember> getAllProjectMembers() {
        return projectMemberRepository.findAll();
    }

    @Override
    public Optional<ProjectMember> getProjectMemberById(Long id) {
        return projectMemberRepository.findById(id);
    }

    @Override
    public ProjectMember addProjectMember(ProjectMember projectMember) {
        Optional<Member> member = memberRepository.findById(projectMember.getMember().getId());
        Optional<Project> project = projectRepository.findById(projectMember.getProject().getId());

        if (member.isPresent() && project.isPresent()) {
            projectMember.setMember(member.get());
            projectMember.setProject(project.get());
            return projectMemberRepository.save(projectMember);
        } else {
            return null;
        }
    }

    @Override
    public ProjectMember updateProjectMember(Long id, ProjectMember projectMemberDetails) {
        Optional<ProjectMember> projectMemberOptional = projectMemberRepository.findById(id);
        if (projectMemberOptional.isPresent()) {
            ProjectMember projectMember = projectMemberOptional.get();
            projectMember.setMember(projectMemberDetails.getMember());
            projectMember.setProject(projectMemberDetails.getProject());
            return projectMemberRepository.save(projectMember);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProjectMember(Long id) {
        projectMemberRepository.deleteById(id);
    }

}
