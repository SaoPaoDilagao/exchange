package com.nttdata.exchange.service;

import java.time.LocalDate;

import com.nttdata.exchange.entity.Exchange;

import reactor.core.publisher.Mono;

public interface ExchangeService {
	
	Mono<Exchange> create(Exchange exchange);
	Mono<Exchange> findByExchangeDate(LocalDate exchangeData);
	Mono<Exchange> update(Exchange exchange);
	Mono<Exchange> delete(LocalDate exchangeData);
}
