package com.examly.springapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TaskRepository extends JpaRepository<ModelTask, Integer> {
}