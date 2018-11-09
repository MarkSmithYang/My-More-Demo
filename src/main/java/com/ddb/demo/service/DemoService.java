package com.ddb.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ddb.demo.model.CtiyAndPerson;
import com.ddb.demo.model.DemoModel;
import com.ddb.demo.repository.DemoRepository;

/**
 * @author Administrator
 *
 */
@Service
public class DemoService {

	@Autowired
	private DemoRepository demoRepository;

	public Page<DemoModel> findDemo(final String name,final String age) {
		
//		Page<DemoModel> result = demoRepository.findAll(new Specification<DemoModel>() {
//			
//			public Predicate toPredicate(Root<DemoModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				List<Predicate> list = new ArrayList<Predicate>();
//				Path<String> un = root.get("username");
//				if (name!=null && !"".equals(name)) {
////					list.add(cb.like(root.get("username").as(String.class), "%"+name+"%"));
//					list.add(cb.like(un, "%"+name+"%"));
//				}
//				if (age!=null && !"".equals(age)) {
//					list.add(cb.like(root.get("age").as(String.class), age));
//				}
//				Predicate[] p = new Predicate[list.size()];
//				return cb.and(list.toArray(p));
//			}
//		}, new PageRequest(0, 9, Direction.DESC, "id"));
//		return result;
		
		Page<DemoModel> result = demoRepository.findAll(new Specification<DemoModel>() {

			@Override
			public Predicate toPredicate(Root<DemoModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> expressions = predicate.getExpressions();
				if (StringUtils.isNotBlank(name)) {
					expressions.add(cb.like(root.get("username"),"%"+name+"%"));
//					expressions.add(cb.like(root.<String>get(name),"%a%"));
				}
				if (StringUtils.isNotBlank(age)) {
					expressions.add(cb.equal(root.<String>get("age"), age));
				}
				return predicate;
			}
		}, new PageRequest(0, 4, Direction.DESC, "id"));
		
		
		long count = demoRepository.count(new Specification<DemoModel>() {

			@Override
			public Predicate toPredicate(Root<DemoModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> expressions = predicate.getExpressions();
				if (StringUtils.isNotBlank(name)) {
					expressions.add(cb.like(root.get("username"),"%"+name+"%"));
//					expressions.add(cb.like(root.<String>get(name),"%a%"));//似乎不加泛型,也没有什么问题
				}
				if (StringUtils.isNotBlank(age)) {
					expressions.add(cb.equal(root.<String>get("age"), age));
				}
				return predicate;
			}
		});
		System.err.println("条数为: "+count);
		
		return result;
	}

	/**
	 * 查询所有信息
	 * @return
	 */
	public List<Object> findAll() {
		List<DemoModel> list = demoRepository.findAll();
		if (list!=null && list.size()>0) {
			List<Object> objects = new ArrayList<Object>();
			objects.add("hahahahahahahaha");
			for (DemoModel demoModel : list) {
				objects.add(demoModel);
			}
			return objects;
		}
		return null;
	}

	/**
	 * 查询所有信息
	 * @return
	 */
	public List<DemoModel> findDemoModell() {
		List<DemoModel> list = demoRepository.findAll();
		return list;
	}

	public List<CtiyAndPerson> query() {
		List<CtiyAndPerson> list = demoRepository.query();
		return list;
	}
	
}
