package com.amrest.fastHire.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amrest.fastHire.model.MapTemplateFieldFieldGroup;

@Transactional
@Component
public class MapTemplateFieldFieldGroupServiceImp implements MapTemplateFieldFieldGroupService {

	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapTemplateFieldFieldGroup> findAll() {
		Query query = em.createNamedQuery("MapTemplateFieldFieldGroup.findAll");
		 List<MapTemplateFieldFieldGroup> items = query.getResultList();
	        return items;
	}

	@Override
	@Transactional
	public MapTemplateFieldFieldGroup create(MapTemplateFieldFieldGroup item) {
		em.persist(item);
	       return item;
	}

	@Override
	public MapTemplateFieldFieldGroup findById(String templateId, String fieldGroupId, String fieldId) {
		Query query = em.createNamedQuery("MapTemplateFieldFieldGroup.findById")
				.setParameter("templateId",templateId)
				.setParameter("fieldGroupId", fieldGroupId)
				.setParameter("fieldId", fieldId);
		MapTemplateFieldFieldGroup item = (MapTemplateFieldFieldGroup) query.getSingleResult();
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapTemplateFieldFieldGroup> findByTemplate(String templateId) {
		Query query = em.createNamedQuery("MapTemplateFieldFieldGroup.findByTemplate")
				.setParameter("templateId",templateId);
		List<MapTemplateFieldFieldGroup> items =  query.getResultList();
		return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapTemplateFieldFieldGroup>  findByTemplateFieldGroup(String templateId, String fieldGroupId) {
		Query query = em.createNamedQuery("MapTemplateFieldFieldGroup.findByTemplateFieldGroup")
				.setParameter("templateId",templateId)
				.setParameter("fieldGroupId", fieldGroupId);
		List<MapTemplateFieldFieldGroup> items =  query.getResultList();
		return items;
	}

	@Override
	@Transactional
	public void deleteByObject(MapTemplateFieldFieldGroup item) {
		em.remove(item);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findDistinctFieldGroup(String templateId) {
		Query query = em.createNamedQuery("MapTemplateFieldFieldGroup.findDistinctFieldGroup")
				.setParameter("templateId",templateId);
		List<Object[]> items =  query.getResultList();
		return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapTemplateFieldFieldGroup> findByTemplateFieldGroupManager(String templateId, String fieldGroupId,
			Boolean isVisibleManager) {
		Query query = em.createNamedQuery("MapTemplateFieldFieldGroup.findByTemplateFieldGroupManager")
				.setParameter("templateId",templateId)
				.setParameter("fieldGroupId", fieldGroupId)
				.setParameter("isVisibleManager", isVisibleManager);
		List<MapTemplateFieldFieldGroup> items =  query.getResultList();
		return items;
	}

}
