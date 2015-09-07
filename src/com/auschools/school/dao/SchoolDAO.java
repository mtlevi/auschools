package com.auschools.school.dao;

import java.util.List;

import com.auschools.school.model.School;

public interface SchoolDAO {

	public void saveOrUpdateSchool(School school);
	public List<School> listSchool();
	public School listSchoolById(Long schoolId);
	public void deleteSchool(Long schoolId);
}
