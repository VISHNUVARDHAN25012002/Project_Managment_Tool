package Com.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Com.Project.Entity.ProjectMember;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
}
