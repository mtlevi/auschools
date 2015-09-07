package com.auschools.school.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.auschools.school.dao.SchoolDAO;
import com.auschools.school.impl.SchoolDAOImpl;
import com.auschools.school.model.School;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SchoolAction extends ActionSupport implements ModelDriven<School> {

	private static final long serialVersionUID = -6659925652584240539L;

	private School school = new School();
	private List<School> schoolList = new ArrayList<School>();
	private SchoolDAO schoolDAO = new SchoolDAOImpl();
	
	@Override
	public School getModel() {
		return school;
	}
	
	/**
	 * To save or update a school.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		schoolDAO.saveOrUpdateSchool(school);
		return SUCCESS;
	}
	
	/**
	 * To list all schools.
	 * @return String
	 */
	public String list()
	{
		schoolList = schoolDAO.listSchool();
		return SUCCESS;
	}
	
	/**
	 * To delete a school.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		schoolDAO.deleteSchool(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single school by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		school = schoolDAO.listSchoolById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<School> getSchoolList() {
		return schoolList;
	}

	public void setSchoolList(List<School> schoolList) {
		this.schoolList = schoolList;
	}

}
