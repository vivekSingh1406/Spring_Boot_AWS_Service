package in.rds_service.service;

import java.util.List;

import in.rds_service.binding.Course;

public interface CourseService {

	public String upsert(Course course);

	public Course getById(Integer cid);

	public List<Course> getAllCourses();

	public String deleteById(Integer cid);

}
