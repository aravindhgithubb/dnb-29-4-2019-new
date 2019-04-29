package com.dnb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dnb.model.Accomodation;
import com.dnb.model.Person;
import com.dnb.serviceimpl.CustomerDetailsImpl;

@Controller
public class DNBController {

	@Autowired
	private CustomerDetailsImpl customerDetailsImpl;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loadLogin(String username,String password) {

		return new ModelAndView("login");

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView getCustomerDetail(ModelMap mod,String username,String password) {
		if(username.equals("john") && password.equals("john")) {
			mod.addAttribute("loginName", username);
			return new ModelAndView("search");
		}else {
			return new ModelAndView("failure");
		}
	}


	@RequestMapping(value = "/search/{searchKey}", method = RequestMethod.GET)
	public @ResponseBody List<Person> getCustomerDetails(@PathVariable(value = "searchKey") String searchKey)
			throws Exception {
		List<Person> cusPo = new ArrayList<Person>();
		cusPo = customerDetailsImpl.getCustomerDetailsKeySearchFirst(searchKey);
		return cusPo;
	}
	@RequestMapping(value = "/searchlast/{searchKey}", method = RequestMethod.GET)
	public @ResponseBody List<Person> getCustomerDetailsLast(@PathVariable(value = "searchKey") String searchKey)
			throws Exception {
		List<Person> cusPo = new ArrayList<Person>();
		cusPo = customerDetailsImpl.getCustomerDetailsKeySearchLast(searchKey);
		return cusPo;
	}
	@RequestMapping(value = "/searchmob/{searchKey}", method = RequestMethod.GET)
	public @ResponseBody List<Person> getCustomerDetailsMob(@PathVariable(value = "searchKey") String searchKey)
			throws Exception {
		List<Person> cusPo = new ArrayList<Person>();
		cusPo = customerDetailsImpl.getCustomerDetailsKeySearchMob(searchKey);
		return cusPo;
	}
	@RequestMapping(value = "/searchemail/{searchKey}", method = RequestMethod.GET)
	public @ResponseBody List<Person> getCustomerDetailsEmail(@PathVariable(value = "searchKey") String searchKey)
			throws Exception {
		List<Person> cusPo = new ArrayList<Person>();
		cusPo = customerDetailsImpl.getCustomerDetailsKeyMail(searchKey);
		return cusPo;
	}
	@RequestMapping(value = "/searchadd/{searchKey}", method = RequestMethod.GET)
	public @ResponseBody List<Person> getCustomerDetailsAdd(@PathVariable(value = "searchKey") String searchKey)
			throws Exception {
		List<Person> cusPo = new ArrayList<Person>();
		cusPo = customerDetailsImpl.getCustomerDetailsKeyAdd(searchKey);
		return cusPo;
	}
	@RequestMapping(value = "/newSearch", method = RequestMethod.GET)
	public ModelAndView getCustomerDetailsSearch(ModelMap mod) {
		//CustomerDetails cusPo = new CustomerDetails();
		//mod.addAttribute(cusPo);
		return new ModelAndView("search");
	}

	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("/login");// if you have two differenet web pages for login and logout else you can
											// redirect to login.jsp
	}

	@RequestMapping(value = "/newResult", method = RequestMethod.GET)
	public ModelAndView getCustomerDetails(@ModelAttribute("cusPo") Person cusPo,
			@FormParam("name") String name, @FormParam("phoneNo") String phoneNo,@FormParam("lname") String lname,@FormParam("address") String address,@FormParam("email") String email, Model model, ModelMap m) {
		System.out.println("inside customer details");

		List<Person> cus;
		try {
			cus = customerDetailsImpl.getCustomerDetails(name, phoneNo,lname,address,email);
			if (cus != null) {
				model.addAttribute("firstname", cus.iterator().next().getFirstname());
				model.addAttribute("lastname", cus.iterator().next().getLastname());
				model.addAttribute("mobilephone", cus.iterator().next().getPhone_mobile());
				model.addAttribute("phonehome", cus.iterator().next().getPhone_home());
				model.addAttribute("email", cus.iterator().next().getEmail());
				model.addAttribute("streetaddress", cus.iterator().next().getStreetaddress());
				model.addAttribute("postalcode", cus.iterator().next().getPostalcode());
				model.addAttribute("economicaladvice", cus.iterator().next().getEconomicaladvice());
				model.addAttribute("Town", cus.iterator().next().getTown());
				model.addAttribute("birthday", cus.iterator().next().getBirthday());
				model.addAttribute("note", cus.iterator().next().getNote());
				model.addAttribute("emprof", cus.iterator().next().getEmprofid());
				model.addAttribute("hasowner", cus.iterator().next().getHasownership());
				model.addAttribute("latestbiding", cus.iterator().next().getLatestbidding());
				model.addAttribute("isbuyer", cus.iterator().next().getIsbuyer());
				
				model.addAttribute("postalcode",cus.iterator().next().getOwns().iterator().next().getAccomodation().getPostalcode());
				model.addAttribute("streetaddress",cus.iterator().next().getOwns().iterator().next().getAccomodation().getStreetaddress());
				model.addAttribute("areal",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getAreal());
				model.addAttribute("rooms",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getRooms());
				model.addAttribute("currency",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getCurrency());
				model.addAttribute("accomodation",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getPostalcode());
				model.addAttribute("agentid",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getAgentid());
				model.addAttribute("officeid",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getOfficeid());
				model.addAttribute("created",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getCreated());
				model.addAttribute("acctype",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getAccomodationtype());
				model.addAttribute("consyear",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getConstructionyear());
				model.addAttribute("lastupdated",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getLastupdated());
				model.addAttribute("town",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getTown());
				model.addAttribute("apartnumner",cus.iterator().next().getOwns().listIterator().next().getAccomodation().getApartmentnumber());
				
				model.addAttribute("ownstreet", cus.iterator().next().getOwns().iterator().next().getSource());
				model.addAttribute("statuschanged", cus.iterator().next().getOwns().iterator().next().getStatuschanged());
				model.addAttribute("lasst", cus.iterator().next().getOwns().iterator().next().getLastupdated());
				model.addAttribute("owned", cus.iterator().next().getOwns().iterator().next().getOwned());
				
				model.addAttribute("idcrm", cus.iterator().next().getBankCrmLead().iterator().next().getId());
				//model.addAttribute("personid", cus.iterator().next().getBankCrmLead().iterator().next().getPerson());
				model.addAttribute("agentid", cus.iterator().next().getBankCrmLead().iterator().next().getAgentid());
				model.addAttribute("createdd", cus.iterator().next().getBankCrmLead().iterator().next().getCreated());
				
				
			//	model.addAttribute("idint", cus.iterator().next().getInterests().iterator().next().getAccomodation());
			//	model.addAttribute("peronint", cus.iterator().next().getInterests().iterator().next().);
				model.addAttribute("createint", cus.iterator().next().getInterests().iterator().next().getCreated());
				model.addAttribute("statusinter", cus.iterator().next().getInterests().iterator().next().getStatuschanged());
				model.addAttribute("ratingint", cus.iterator().next().getInterests().iterator().next().getRating());
				model.addAttribute("noteint", cus.iterator().next().getInterests().iterator().next().getNote());
				
				/*for (Accomodation tmp : cus.i {
					model.addAttribute("Visit", tmp.getStarttime());
					model.addAttribute("visitid", tmp.getPersonid());
					model.addAttribute("id", tmp.getCustDetails().getId());
				}*/
			//	System.out.println("++++++" + cus.iterator().next().getConer().iterator().next().getCowner());
				// model.addAttribute("coner",
				// cus.iterator().next().getConer().iterator().next().getCowner());

				ModelAndView m1 = new ModelAndView();
				m.addAttribute("model", model);
				m1.setViewName("newResult");
				m1.addObject("model", model);
				m1.addObject("fname", "aravindh");
                return m1;
			}
		}
	catch (Exception e) {
			System.out.println("Exception" + e);
		}
		return new ModelAndView("newResult");
	}
@RequestMapping(value = "/cusDownLoadExcel", method = RequestMethod.GET)
public ModelAndView getCustomerDetailsDownloadExcel() {
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
	
	
	
	/*@ResponseBody
	@RequestMapping(value = "/dnb/{searchKey}", method = RequestMethod.GET)

	public ModelAndView getCustomerDetail(@PathVariable(value = "searchKey") String searchKey, Model model)
			throws Exception {
		List<CustomerDetails> cusPo = new ArrayList<CustomerDetails>();
		ModelAndView m1 = new ModelAndView();
		try {
			cusPo = customerDetailsImpl.getCustomerDetailsKeySearch(searchKey);
			model.addAttribute("mode", cusPo);
			m1.setViewName("search");
			m1.addObject("model", model);
		} catch (Exception e) {
			System.out.println(e);
		}
		return m1;
	}

	@RequestMapping(value = "/customerAddDetails", method = RequestMethod.GET)
	public @ResponseBody String getCustomerAddDetails(@FormParam("custid") Integer custid,
			@FormParam("name") String name, @FormParam("phoneNo") String phoneNo,
			@FormParam("address") String address) {
		System.out.println("inside customer details" + custid);
		System.out.println("inside customer details" + name);
		System.out.println("inside customer details" + phoneNo);
		System.out.println("inside customer details" + address);
		CustomerDetails customerDetailsModel = new CustomerDetails();
		customerDetailsModel.setId(custid);
		customerDetailsModel.setName(name);
		customerDetailsModel.setPhone(phoneNo);
		customerDetailsModel.setAddress(address);
		String message = customerDetailsImpl.addCustomerDetails(customerDetailsModel);
		return message;
	}

	@RequestMapping(value = "/customerDeleteDetails", method = RequestMethod.GET)
	public @ResponseBody String getCustomerAddDetails(@FormParam("custid") Integer custid) {
		System.out.println("inside customer details" + custid);
		String message = customerDetailsImpl.deleteCustomerDetails(custid);
		return message;
	}*/
