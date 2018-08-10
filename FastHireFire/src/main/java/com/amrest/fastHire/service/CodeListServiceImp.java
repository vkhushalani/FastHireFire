package com.amrest.fastHire.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amrest.fastHire.model.CodeList;

@Transactional
@Component
public class CodeListServiceImp implements CodeListService {

	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CodeList> findAll() {
		Query query = em.createNamedQuery("CodeList.findAll");
		 List<CodeList> items = query.getResultList();
	        return items;
	}

	@Override
	@Transactional
	public CodeList update(CodeList item) {
		em.merge(item);
	       return item;
	}

	@Override
	@Transactional
	public CodeList create(CodeList item) {
		em.persist(item);
	       return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeList> findByFieldId(String fieldId) {
		Query query = em.createNamedQuery("CodeList.findByFieldId")
				.setParameter("fieldId", fieldId);
		 List<CodeList> items = query.getResultList();
	        return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeList> findByCountryField(String fieldId, String countryId) {
		Query query = em.createNamedQuery("CodeList.findByCountryField")
				.setParameter("fieldId", fieldId)
				.setParameter("countryId", countryId);
		 List<CodeList> items = query.getResultList();
	        return items;
	}

	@Override
	public CodeList findByCountryFieldLang(String fieldId, String countryId, String language) {
		Query query = em.createNamedQuery("CodeList.findByCountryFieldLang")
				.setParameter("fieldId", fieldId)
				.setParameter("countryId", countryId)
				.setParameter("language",language);
		 CodeList item = (CodeList) query.getSingleResult();
	        return item;
	}

	@Override
	@Transactional
	public void deleteByObject(CodeList item) {
		em.remove(item);

	}

}
