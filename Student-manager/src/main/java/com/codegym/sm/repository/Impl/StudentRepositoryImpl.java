package com.codegym.sm.repository.Impl;

import com.codegym.sm.model.Student;
import com.codegym.sm.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional

public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("select c from Student c", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(Long id) {
        TypedQuery<Student> query = em.createQuery("select c from Student c where c.id=:id", Student.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;

        }
    }


    @Override
    public void save(Student student) {
        if (student.getId() != null) {
            em.merge(student);
        } else {
            em.persist(student);
        }
    }

    @Override
    public void remove(Long id) {
        Student student = findById(id);
        if (student != null) {
            em.remove(student);
        }
    }
}
