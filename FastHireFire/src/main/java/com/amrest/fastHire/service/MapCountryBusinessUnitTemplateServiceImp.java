package com.amrest.fastHire.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amrest.fastHire.model.MapCountryBusinessUnitTemplate;

@Transactional
@Component
public class MapCountryBusinessUnitTemplateServiceImp implements MapCountryBusinessUnitTemplateService {

	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapCountryBusinessUnitTemplate> findAll() {
		Query query = em.createNamedQuery("MapCountryBusinessUnitTemplate.findAll");
		 List<MapCountryBusinessUnitTemplate> items = query.getResultList();
	        return items;
	}

	@Override
	@Transactional
	public MapCountryBusinessUnitTemplate create(MapCountryBusinessUnitTemplate item) {
		em.persist(item);
	       return item;
	}

	@Override
	public MapCountryBusinessUnitTemplate findById(Integer countryId, Integer businessUnitId, String templateId) {
		Query query = em.createNamedQuery("MapCountryBusinessUnitTemplate.findById")
				.setParameter("countryId",countryId)
				.setParameter("businessUnitId", businessUnitId)
				.setParameter("templateId", templateId);
		MapCountryBusinessUnitTemplate item = (MapCountryBusinessUnitTemplate) query.getSingleResult();
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapCountryBusinessUnitTemplate> findByCountry(Integer countryId) {
		Query query = em.createNamedQuery("MapCountryBusinessUnitTemplate.findByCountry")
				.setParameter("countryId",countryId);
		List<MapCountryBusinessUnitTemplate> items =  query.getResultList();
		return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapCountryBusinessUnitTemplate> findByCountryBusinessUnit(Integer countryId, Integer businessUnitId) {
		Query query = em.createNamedQuery("MapCountryBusinessUnitTemplate.findByCountryBusinessUnit")
				.setParameter("countryId",countryId)
				.setParameter("businessUnitId", businessUnitId);
		List<MapCountryBusinessUnitTemplate> items =  query.getResultList();
		return items;
	}

	@Override
	@Transactional
	public void deleteByObject(MapCountryBusinessUnitTemplate item) {
		em.remove(item);

	}

}
