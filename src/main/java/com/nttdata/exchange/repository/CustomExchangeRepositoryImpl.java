package com.nttdata.exchange.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.nttdata.exchange.entity.Exchange;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CustomExchangeRepositoryImpl implements CustomExchangeRepository {
	
	private final ReactiveMongoTemplate mongoTemplate;

	@Override
	public Mono<Exchange> findByExchangeDate(LocalDate exchangeDate) {
		
		Query query = new Query(where("exchangeDate").is(exchangeDate));
    return mongoTemplate.findOne(query, Exchange.class);
		
	}

}
