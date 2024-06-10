package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {}
