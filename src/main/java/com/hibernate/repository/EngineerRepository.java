package com.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.entity.Engineer;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Integer>{

}
