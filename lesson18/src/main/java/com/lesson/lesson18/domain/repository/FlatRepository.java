package com.lesson.lesson18.domain.repository;

import com.lesson.lesson18.domain.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Integer> {
}
