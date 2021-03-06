package repodb.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import repodb.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends MainDao<Employee>{

	@Override
	public Employee byId(int id) {
		return em.find(Employee.class, id);
	}

	@Override
	public List<Employee> byList(String namedQery) {
		TypedQuery<Employee> listEmloyee = em.createNamedQuery(namedQery, Employee.class);
		return listEmloyee.getResultList();
	}


	@Transactional
	public List<Employee> byList(String namedQery, int idDepartment) {
		TypedQuery<Employee> listEmloyee = em.createNamedQuery(namedQery, Employee.class);
		listEmloyee.setParameter("departmentId", idDepartment);
		return listEmloyee.getResultList();
	}
}
