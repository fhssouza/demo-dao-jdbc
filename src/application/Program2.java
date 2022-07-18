package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: Department findByAll ===");
		List<Department> departments = new ArrayList<>();
		departments = departmentDao.findAll();
		for(Department obj : departments) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Department insert ===");
		Department newDep = new Department(null, "D2");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 4: Department update ===");
		department = departmentDao.findById(7);
		department.setName("D3");
		departmentDao.update(department);
		System.out.println("Updated completed");
		
		System.out.println("\n=== TEST 5: Department update ===");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
