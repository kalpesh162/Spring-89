package com.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bean.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private final List<Student> studList = new ArrayList<>();

	@Override
	public boolean addStudent(Student student) {
		return studList.add(student);
	}

	@Override
	public void deleteStudentById(int id) {
		// find Student
		boolean flag = true;
		for (Student student : studList) {
			if (student.getId() == id) {
				studList.remove(student);
				flag = false;
				break;
			}
		}
		if (flag) {
			try {
				throw new RuntimeException("Student with id not found " + id);
			} catch (Exception e) {
				throw e;
			}
		}
		// if yes then delete
		// if no raise an Exception
	}

	@Override
	public boolean updateStudent(int existingID, Student updatedstudent) {
		boolean flag = false;
		for (Student student : studList) {
			if (student.getId() == existingID) {
				student.setMarks(updatedstudent.getMarks());
				student.setName(updatedstudent.getName());
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public Student findStudentById(int id) {
		boolean flag = false;
		for (Student student : studList) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	@Override
	public List<Student> findAllStudents() {

		return studList;
	}

}
