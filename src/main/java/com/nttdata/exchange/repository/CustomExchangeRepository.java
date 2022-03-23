package com.nttdata.exchange.repository;

import java.time.LocalDate;

import com.nttdata.exchange.entity.Exchange;

import reactor.core.publisher.Mono;

public interface CustomExchangeRepository {
	
	 Mono<Exchange>  findByExchangeDate(LocalDate exchangeDate);

}
