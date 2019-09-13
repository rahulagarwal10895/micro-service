package com.metallica.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.metallica.constants.AppConstant;
import com.metallica.model.response.ApiResponse;

@FeignClient(name = AppConstant.APP_NAME_ZUUL_API_GATEWAY)
@RibbonClient(name= AppConstant.APP_NAME_MARKET_DATA_SERVICE)
public interface MarketDataServiceClient {

    @GetMapping("/"+ AppConstant.APP_NAME_MARKET_DATA_SERVICE +"/market/{commodityCode}")
    ResponseEntity<ApiResponse> getMarketPrice(@PathVariable("commodityCode") String commodityCode);
}
