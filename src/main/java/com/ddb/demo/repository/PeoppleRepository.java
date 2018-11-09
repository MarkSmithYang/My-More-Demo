package com.ddb.demo.repository;

import com.ddb.demo.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author biaoyang
 * @Description:
 * @date 2018/9/21 002110:30
 */
public interface PeoppleRepository extends JpaRepository<People,Integer> {

}
