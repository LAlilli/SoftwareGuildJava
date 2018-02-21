/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterAuditDaoStubImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoStubImpl;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
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
public class ClassRosterServiceLayerTest {
    
    private ClassRosterServiceLayer service;
    
    public ClassRosterServiceLayerTest() {
        ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
        
        service = new ClassRosterServiceLayerImpl(dao, auditDao);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student("001");
        student.setFirstName("Joe");
        student.setLastName("Smith");
        student.setCohort(".NET-03");
        
        service.createStudent(student);
    }

    @Test
    public void testCreateStudentDuplicateId() throws Exception{
        Student student = new Student("002");
        student.setFirstName("Joe");
        student.setLastName("Smith");
        student.setCohort(".NET-03");
        
        try {
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateException was not thrown.");
        } catch (ClassRosterDuplicateIdException e){
            return;
        }
    }
    
    @Test
    public void testCreateStudentInvalidData() throws Exception{
        Student student = new Student("001");
        student.setFirstName("");
        student.setLastName("Smith");
        student.setCohort(".NET-03");
        
        try {
            service.createStudent(student);
            fail("Expected ClassRosterDataValidationException was not thrown. ");
        } catch (ClassRosterDataValidationException e){
            return;
        }
    }
    
    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        assertEquals(1, service.getAllStudents().size());
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
        Student student = service.getStudent("001");
        assertNotNull(student);
        student = service.getStudent("999");
        assertNull(student);
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        Student student = service.removeStudent("001");
        assertNotNull(student);
        student = service.removeStudent("999");
        assertNull(student);
    }
}