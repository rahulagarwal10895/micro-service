package com.metallica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metallica.model.entity.Trade;
import com.metallica.model.response.ApiResponse;
import com.metallica.service.ITradeService;

@RestController
@RequestMapping("/trades")
public class TradeController {

	@Autowired
	ITradeService tradeService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createTrade(@Valid @RequestBody Trade trade) {

		Trade createdTrade = tradeService.createTrade(trade);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Successfully created!");
		apiResponse.setStatus("SUCCESS");
		apiResponse.setResponse(createdTrade);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{tradeId}")
	public ResponseEntity<ApiResponse> getTrade(@PathVariable Long tradeId) {

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setResponse(tradeService.getTrade(tradeId));
		apiResponse.setMessage("Successful");
		apiResponse.setStatus("SUCCESS");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateTrade(@Valid @RequestBody Trade trade) {

		Trade createdTrade = tradeService.updateTrade(trade);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setResponse(createdTrade);
		apiResponse.setMessage("Successful");
		apiResponse.setStatus("SUCCESS");

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{tradeId}")
	public ResponseEntity<ApiResponse> deleteTrade(@PathVariable  Long tradeId) {

		ApiResponse apiResponse=new ApiResponse();
		tradeService.deleteById(tradeId);
		apiResponse.setMessage("Successfully deleted!");
		apiResponse.setStatus("SUCCESS");
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
		
	}

}
