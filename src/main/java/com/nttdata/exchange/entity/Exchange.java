package com.nttdata.exchange.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.nttdata.exchange.dto.request.ExchangeRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exchange {
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate exchangeDate;
	@Field(targetType = FieldType.DECIMAL128)
	private BigDecimal purchase;
	@Field(targetType = FieldType.DECIMAL128)
	private BigDecimal sale;
	
	
	public Exchange(ExchangeRequest request) {
		exchangeDate = request.getExchangeDate();
		purchase = request.getPurchase();
		sale = request.getSale();
  }
	
	
	
}
