package com.auschools.school.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.auschools.school.dao.SchoolDAO;
import com.auschools.school.model.School;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class SchoolDAOImpl implements SchoolDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a school.
	 */
	@Override
	public void saveOrUpdateSchool(School school) {
		try {
			session.saveOrUpdate(school);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a school.
	 */
	@Override
	public void deleteSchool(Long schoolId) {
		try {
			School school = (School) session.get(School.class, schoolId);
			session.delete(school);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the schools.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<School> listSchool() {
		List<School> schoolList = null;
		try {
			schoolList = session.createQuery("from School").list();
			Collections.sort(schoolList, new Comparator<School>(){
				@Override public int compare(School s1, School s2) {
		            return s1.getName().compareToIgnoreCase(s2.getName());
		        }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return schoolList;
	}

	/**
	 * Used to list a single school by Id.
	 */
	@Override
	public School listSchoolById(Long schoolId) {
		School school = null;
		try {
			school = (School) session.get(School.class, schoolId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return school;
	}

}
