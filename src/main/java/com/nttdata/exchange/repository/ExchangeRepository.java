package com.nttdata.exchange.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.exchange.entity.Exchange;

@Repository
public interface ExchangeRepository extends ReactiveMongoRepository<Exchange, ObjectId>,
	CustomExchangeRepository{

}
