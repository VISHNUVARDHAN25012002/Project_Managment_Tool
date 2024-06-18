package Com.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Com.Project.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
