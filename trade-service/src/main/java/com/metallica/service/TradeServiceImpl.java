package com.metallica.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.metallica.client.MarketDataServiceClient;
import com.metallica.constants.AppConstant;
import com.metallica.dao.TradeDao.TradeDao;
import com.metallica.exception.ServiceException;
import com.metallica.exception.TradeNotFoundException;
import com.metallica.model.entity.Trade;
import com.metallica.model.response.ApiResponse;
import com.metallica.rabbitmq.MessageSender;

@Component
public class TradeServiceImpl implements ITradeService {

    @Autowired
    TradeDao tradeDao;

    
    @Autowired
    MarketDataServiceClient mdClient;

    @Autowired
    MessageSender publisher;

    @Override
    public Trade createTrade(Trade trade) {
        trade.setTradeDate(new Date());
        if (tradeDao.countById(trade.getId()) > 0) {
            throw new ServiceException("ER-1002", "Trade already exists!");
        }
        ResponseEntity<ApiResponse> mdResponse = mdClient.getMarketPrice(trade.getCommodity());
        System.out.println(mdResponse.getBody().getResponse());
        Map<String,Double> response =(LinkedHashMap<String,Double>)mdResponse.getBody().getResponse();
        
        trade.setPrice((BigDecimal.valueOf((response.get("price")))));
        
        trade.setTradeStatus(AppConstant.INITIATED);
        tradeDao.save(trade);
        publisher.produceMsg(trade);
        return trade;
    }

    @Override
    public Trade getTrade(Long tradeId) {
        Optional<Trade> trade = tradeDao.findById(tradeId);
        if (!trade.isPresent()) {
            throw new TradeNotFoundException("ER-1001", "Trade not found!");
        }
        /*ServiceResponse<GetAllCommoditiesResponse> commodities = client.getAllCommodities();
        commodities.getResponse().getCommodities().stream().forEach(e -> System.out.println("" + e));*/
        return trade.get();
    }

    @Override
    public Trade updateTrade(Trade trade) {
        if (tradeDao.countById(trade.getId()) <= 0) {
            throw new ServiceException("ER-1003", "No such Trade exists!");
        }
        return tradeDao.save(trade);
    }

    @Override
    public void deleteById(Long tradeId) {
        if (tradeDao.countById(tradeId) <= 0) {
            throw new ServiceException("ER-1003", "No such Trade exists!");
        }
        tradeDao.deleteById(tradeId);
    }
}
