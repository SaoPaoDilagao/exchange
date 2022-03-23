package com.nttdata.exchange.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.exchange.dto.request.DateRequest;
import com.nttdata.exchange.dto.request.ExchangeRequest;
import com.nttdata.exchange.entity.Exchange;
import com.nttdata.exchange.service.ExchangeService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange")
public class ExchangeController {
	
	private final ExchangeService exchangeServices;
	
	@PostMapping("/create")
	@ResponseStatus(CREATED)
	Mono<Exchange> createExchange(@RequestBody ExchangeRequest request){
		Exchange data = new Exchange(request);
		return exchangeServices.create(data);
	}
	
	@GetMapping("/findByDate")
	Mono<Exchange> findByDate(@RequestBody DateRequest request){
	  
		return exchangeServices.findByExchangeDate(request.getExchangeDate());
	}
	
	@PutMapping("/update")
	Mono<Exchange> update(@RequestBody Exchange request){
		return exchangeServices.update(request);
	}
	
	@DeleteMapping("/delete")
	Mono<Exchange> delete(@RequestBody DateRequest request){
		
		return exchangeServices.delete(request.getExchangeDate());
	}
	
}
