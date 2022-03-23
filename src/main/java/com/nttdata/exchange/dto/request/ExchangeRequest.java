package com.nttdata.exchange.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRequest {
	
	@NotNull(message = "Field exchangeDate must be required")
	@JsonFormat(pattern = "dd/MM/yyyy")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate exchangeDate;
	@NotNull(message = "Field purchase must be required")
	private BigDecimal purchase;
	@NotNull(message = "Field sale must be required")
	private BigDecimal sale;

}
