package com.nttdata.exchange.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.nttdata.exchange.entity.Exchange;
import com.nttdata.exchange.exceptions.custom.CustomInformationException;
import com.nttdata.exchange.repository.ExchangeRepository;
import com.nttdata.exchange.utilities.Constants;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
	
	private final ExchangeRepository exchangeRepository;

	@Override
	public Mono<Exchange> create(Exchange exchange) {
		return exchangeRepository.findByExchangeDate(exchange.getExchangeDate())
		.doOnNext( a ->Mono.error(new CustomInformationException(Constants.ExchangeErrorMsg.MONO_CONFLICT_MESSAGE))) 
		.switchIfEmpty(exchangeRepository.save(exchange));
	}

	@Override
	public Mono<Exchange> findByExchangeDate(LocalDate exchangeDate) {
		return exchangeRepository.findByExchangeDate(exchangeDate)
				.switchIfEmpty(Mono.error(new CustomInformationException(Constants.ExchangeErrorMsg.MONO_NOT_FOUND_MESSAGE)));
	}

	@Override
	public Mono<Exchange> update(Exchange exchange) {
		return exchangeRepository.findByExchangeDate(exchange.getExchangeDate())
				.switchIfEmpty(Mono.error(new CustomInformationException(Constants.ExchangeErrorMsg.MONO_NOT_FOUND_MESSAGE)))
				.map(data -> {
					
					data.setExchangeDate(exchange.getExchangeDate());
					data.setPurchase(exchange.getPurchase());
					data.setSale(exchange.getSale());
					exchangeRepository.save(data).subscribe();
					return exchange;
					});
	}

	@Override
	public Mono<Exchange> delete(LocalDate exchangeData) {
		return exchangeRepository.findByExchangeDate(exchangeData)
				.switchIfEmpty(Mono.error(new CustomInformationException(Constants.ExchangeErrorMsg.MONO_NOT_FOUND_MESSAGE)))
				.map(data -> {
					exchangeRepository.delete(data).subscribe();
					return data;
				});
	}

}
