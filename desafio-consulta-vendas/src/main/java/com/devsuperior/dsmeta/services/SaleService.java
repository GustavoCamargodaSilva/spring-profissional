package com.devsuperior.dsmeta.services;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;

import com.devsuperior.dsmeta.projections.SaleMinProjection;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleMinDTO> searchPagedSalesWithInitialDateFinalDateAnSellerName(
			String minDateStr, String maxDateStr, String name, Pageable pageable){

		LocalDate minDate;
		LocalDate maxDate;

		try {
			minDate = LocalDate.parse(minDateStr);
			maxDate = LocalDate.parse(maxDateStr);
		}catch (DateTimeException e){
			throw new IllegalArgumentException("Formato de data está inválido.");
		}

		Page<SaleMinProjection> saleMinProjectionPage = repository
				.searchByInitialDateFinalDateAndSellerPartialName(minDate, maxDate, name, pageable);
		Page<SaleMinDTO> res = saleMinProjectionPage.map(x -> new SaleMinDTO(x));
		return res;
	}
}
