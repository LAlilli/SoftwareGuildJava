/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.HashSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LA-San
 */
public class ClassRosterDaoTest {
    
    private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    
    public ClassRosterDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<Student>studentList = dao.getAllStudents();
        for (Student student : studentList){
            dao.removeStudent(student.getStudentId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addStudent method, of class ClassRosterDao.
     */
    @org.junit.Test
    public void testAddGetStudent() throws Exception {
        Student student = new Student("001");
        student.setFirstName("Joe");
        student.setLastName("Smith");
        student.setCohort("JAVA-May 2018");
        
        dao.addStudent(student.getStudentId(), student);
        
        Student fromDao = dao.getStudent(student.getStudentId());
        
        assertEquals(student, fromDao);
    }

    /**
     * Test of getAllStudents method, of class ClassRosterDao.
     */
    @org.junit.Test
    public void testGetAllStudents() throws Exception {
        Student student1 = new Student("001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("JAVA-Dec 2017");
        
        dao.addStudent(student1.getStudentId(), student1);
        
        Student student2 = new Student("002");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setCohort(".NET-Dec 2017");
        
        dao.addStudent(student2.getStudentId(), student2);
        
        assertEquals(2, dao.getAllStudents().size());
    }

    /**
     * Test of removeStudent method, of class ClassRosterDao.
     */
    @org.junit.Test
    public void testRemoveStudent() throws Exception {
        Student student1 = new Student("001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("JAVA-Dec 2017");
        
        dao.addStudent(student1.getStudentId(), student1);
        
        Student student2 = new Student("002");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setCohort(".NET-Dec 2017");
        
        dao.addStudent(student2.getStudentId(), student2);
        
        dao.removeStudent(student1.getStudentId());
        assertEquals(1, dao.getAllStudents().size());
        assertNull(dao.getStudent(student1.getStudentId()));
        
        dao.removeStudent(student2.getStudentId());
        assertEquals(0, dao.getAllStudents().size());
        assertNull(dao.getStudent(student2.getStudentId()));
    }  
}
