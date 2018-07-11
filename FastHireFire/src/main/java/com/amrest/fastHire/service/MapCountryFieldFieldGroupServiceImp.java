package com.amrest.fastHire.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amrest.fastHire.model.MapCountryFieldFieldGroup;

@Transactional
@Component
public class MapCountryFieldFieldGroupServiceImp implements MapCountryFieldFieldGroupService {

	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapCountryFieldFieldGroup> findAll() {
		Query query = em.createNamedQuery("MapCountryFieldFieldGroup.findAll");
		 List<MapCountryFieldFieldGroup> items = query.getResultList();
	        return items;
	}

	@Override
	@Transactional
	public MapCountryFieldFieldGroup create(MapCountryFieldFieldGroup item) {
		em.persist(item);
	       return item;
	}

	@Override
	public MapCountryFieldFieldGroup findById(Integer countryId, String fieldGroupId, String fieldId) {
		Query query = em.createNamedQuery("MapCountryFieldFieldGroup.findById")
				.setParameter("countryId",countryId)
				.setParameter("fieldGroupId", fieldGroupId)
				.setParameter("fieldId", fieldId);
		MapCountryFieldFieldGroup item = (MapCountryFieldFieldGroup) query.getSingleResult();
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapCountryFieldFieldGroup> findByCountry(Integer countryId) {
		Query query = em.createNamedQuery("MapCountryFieldFieldGroup.findByCountry")
				.setParameter("countryId",countryId);
		List<MapCountryFieldFieldGroup> items =  query.getResultList();
		return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapCountryFieldFieldGroup> findByCountryFieldGroup(Integer countryId, String fieldGroupId) {
		Query query = em.createNamedQuery("MapCountryFieldFieldGroup.findByCountryFieldGroup")
				.setParameter("countryId",countryId)
				.setParameter("fieldGroupId", fieldGroupId);
		List<MapCountryFieldFieldGroup> items =  query.getResultList();
		return items;
	}

	@Override
	@Transactional
	public void deleteByObject(MapCountryFieldFieldGroup item) {
		em.remove(item);

	}

}
