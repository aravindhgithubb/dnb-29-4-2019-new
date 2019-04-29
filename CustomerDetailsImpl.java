package com.dnb.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.dnb.model.Person;
import com.dnb.util.HibernateUtil;

@Repository
@Transactional
public class CustomerDetailsImpl {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Person> getCustomerDetails(String custName, String phoneNo,String lname,String address,String email) throws Exception {
		List<Person> custDetList = null;
		if ((custName != null && !"".equals(custName)) && (phoneNo != null && !"".equals(phoneNo)) && (lname != null && !"".equals(lname))&& (address != null && !"".equals(address))&& (email != null && !"".equals(email))) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person a WHERE a.firstname=:custName AND a.lastname=:lname  AND a.phone_mobile=:phoneNo  AND a.streetaddress=:address  AND a.email=:email");
			query.setParameter("custName", custName);
			query.setParameter("phoneNo", phoneNo);
			query.setParameter("lname",lname );
			query.setParameter("address", address);
			query.setParameter("email", email);
			custDetList = query.getResultList();
			return custDetList;
		} else if (custName != null && !"".equals(custName)) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person a WHERE a.firstname=:custName");
			query.setParameter("custName", custName);
			System.out.println(query);
			custDetList = query.getResultList();
			return custDetList;
		} else if (phoneNo != null && !"".equals(phoneNo)) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person a WHERE a.phone_mobile=:phoneNo");
			query.setParameter("phoneNo", phoneNo);
			custDetList = query.getResultList();
			return custDetList;
		}
		else if (lname != null && !"".equals(lname)) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person a WHERE a.lastname=:lname");
			query.setParameter("lname", lname);
			custDetList = query.getResultList();
			return custDetList;
		}
		else if (address != null && !"".equals(address)) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person a WHERE a.streetaddress=:address");
			query.setParameter("address", address);
			custDetList = query.getResultList();
			return custDetList;
		}
		else if (email != null && !"".equals(email)) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person a WHERE a.email=:email");
			query.setParameter("email", email);
			custDetList = query.getResultList();
			return custDetList;
		}
		return custDetList;
	}


	public List<Person> getCustomerDetailsKeySearchFirst(String custName) throws Exception {
		List<Person> custDetList = null;
		System.out.println("cust" + custName);
		Person simpleModelList1 = new Person();
		// String simpleModelList1="";
		if (custName != null && !"".equals(custName)) {

			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person WHERE firstname like concat(:custName,'%')");
			query.setParameter("custName", custName);
			custDetList = query.getResultList();
			System.out.println("Search List size ---------------" + custDetList.size());
			System.out.println(simpleModelList1);
			// return simpleModelList1;
		}
		return custDetList;
	}
	public List<Person> getCustomerDetailsKeySearchLast(String custName) throws Exception {
		List<Person> custDetList = null;
		System.out.println("cust" + custName);
		Person simpleModelList1 = new Person();
		// String simpleModelList1="";
		if (custName != null && !"".equals(custName)) {

			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person WHERE lastname like concat(:custName,'%')");
			query.setParameter("custName", custName);
			custDetList = query.getResultList();
			System.out.println("Search List size ---------------" + custDetList.size());
			System.out.println(simpleModelList1);
			// return simpleModelList1;
		}
		return custDetList;
	}
	public List<Person> getCustomerDetailsKeySearchMob(String custName) throws Exception {
		List<Person> custDetList = null;
		System.out.println("cust" + custName);
		Person simpleModelList1 = new Person();
		// String simpleModelList1="";
		if (custName != null && !"".equals(custName)) {

			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person WHERE phone_mobile like concat(:custName,'%')");
			query.setParameter("custName", custName);
			custDetList = query.getResultList();
			System.out.println("Search List size ---------------" + custDetList.size());
			System.out.println(simpleModelList1);
			// return simpleModelList1;
		}
		return custDetList;
	}
	public List<Person> getCustomerDetailsKeyMail(String custName) throws Exception {
		List<Person> custDetList = null;
		System.out.println("cust" + custName);
		Person simpleModelList1 = new Person();
		// String simpleModelList1="";
		if (custName != null && !"".equals(custName)) {

			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person WHERE email like concat(:custName,'%')");
			query.setParameter("custName", custName);
			custDetList = query.getResultList();
			System.out.println("Search List size ---------------" + custDetList.size());
			System.out.println(simpleModelList1);
			// return simpleModelList1;
		}
		return custDetList;
	}
	public List<Person> getCustomerDetailsKeyAdd(String custName) throws Exception {
		List<Person> custDetList = null;
		System.out.println("cust" + custName);
		Person simpleModelList1 = new Person();
		// String simpleModelList1="";
		if (custName != null && !"".equals(custName)) {

			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Person WHERE streetaddress like concat(:custName,'%')");
			query.setParameter("custName", custName);
			custDetList = query.getResultList();
			System.out.println("Search List size ---------------" + custDetList.size());
			System.out.println(simpleModelList1);
			// return simpleModelList1;
		}
		return custDetList;
	}
/*
	public String addCustomerDetails(CustomerDetails customerDetails) {

		entityManager.persist(customerDetails);
		return "Record Successfully Added";
	}

	public String deleteCustomerDetails(Integer id) {
		// List<CustomerDetails> simpleModelList = entityManager.createQuery("select a
		// from CustomerDetails a where a.name like
		// :custName",CustomerDetails.class).setParameter("custName",
		// custName).getResultList();
		CustomerDetails customerDetails = entityManager.find(CustomerDetails.class, id);
		entityManager.remove(customerDetails);
		return "Record Deleted Successfully";
	}
*/
	public List<Person> exportToExcel() {
		try {
			String excelRootpath = "C:\\dnbexcel\\dnb.xlsx";
			FileOutputStream fileOutput = new FileOutputStream(new File(excelRootpath));
			// create xlsx workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			// create new worksheet
			XSSFSheet sheet = workbook.createSheet("Dnb Customers");
			Object[][] dnbCustomers = { { "Name", "887" }, { "Name1", "123" }, { "Name3", "345" } };
			int rowNum = 0;
			for (Object[] customers : dnbCustomers) {
				Row row = sheet.createRow(rowNum++);
				int column = 0;
				for (Object value : customers) {
					Cell cell = row.createCell(column++);
					if (value instanceof String) {
						cell.setCellValue((String) value);
					} else if (value instanceof Integer) {
						cell.setCellValue((Integer) value);
					}
				}
			}
			workbook.write(fileOutput);
			System.out.println("Customers data exported");
			//workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
