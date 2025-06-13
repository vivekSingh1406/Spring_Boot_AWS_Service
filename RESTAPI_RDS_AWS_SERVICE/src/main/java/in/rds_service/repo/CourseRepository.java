package in.rds_service.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rds_service.binding.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable> {

}
