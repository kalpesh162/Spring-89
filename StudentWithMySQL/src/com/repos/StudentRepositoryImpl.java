package com.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.bean.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private final List<Student> studList = new ArrayList<>();

	private DriverManagerDataSource dataSource;

	@Autowired
	public StudentRepositoryImpl(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean addStudent(Student student) {
		try (Connection connection = dataSource.getConnection();) {
			String sql = "insert into student (name,marks)  values (?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setDouble(2, student.getMarks());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

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
