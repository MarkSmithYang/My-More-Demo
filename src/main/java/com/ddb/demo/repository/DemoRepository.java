package com.ddb.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ddb.demo.model.CtiyAndPerson;
import com.ddb.demo.model.DemoModel;

public interface DemoRepository extends JpaRepository<DemoModel, String>,JpaSpecificationExecutor<DemoModel>,PagingAndSortingRepository<DemoModel, String>{

	@Query(value ="select * from city c join person p where c.country = p.country",nativeQuery = true)
	public List<CtiyAndPerson> query();

}
