package com.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.bean.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

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
		String sql = "DELETE FROM student WHERE id = ?";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, id);

			int rows = ps.executeUpdate();

			if (rows == 0) {
				throw new RuntimeException("Student with id not found: " + id);
			}

		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Error deleting student", e);
		}
	}

	@Override
	public boolean updateStudent(int existingID, Student updatedstudent) {
		String sql = "UPDATE student SET name = ?, marks = ? WHERE id = ?";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, updatedstudent.getName());
			ps.setDouble(2, updatedstudent.getMarks());
			ps.setInt(3, existingID);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Student findStudentById(int id) {
		String sql = "SELECT id, name, marks FROM student WHERE id = ?";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Student student = new Student();

					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setMarks(rs.getDouble("marks"));

					return student;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> studList = new ArrayList<>();

		String sql = "SELECT id, name, marks FROM student";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Student student = new Student();

				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getDouble("marks"));

				studList.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studList;
	}
}
