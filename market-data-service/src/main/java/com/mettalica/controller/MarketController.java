package com.mettalica.controller;

import com.mettalica.dao.MarketDataDao;
import com.mettalica.exception.DataNotFoundException;
import com.mettalica.model.dto.MarketDataDTO;
import com.mettalica.model.dto.ApiResponse;
import com.mettalica.model.entity.MarketData;
import com.mettalica.service.MarketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    MarketService marketService;

    @GetMapping("/{commodityCode}")
    public ResponseEntity<ApiResponse> getMarketPrice(@PathVariable String commodityCode) throws DataNotFoundException{

        MarketDataDTO marketDataDTO = new MarketDataDTO();
        MarketData data = marketService.findByCommodity(commodityCode);
        marketDataDTO.setCommodityCode(data.getCommodity());
        marketDataDTO.setPrice(data.getPrice());
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setResponse(marketDataDTO);
        apiResponse.setStatus("SUCCESS");
        apiResponse.setMessage("Successfully Got");
        		
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
}
