package com.metallica.service;

import com.metallica.model.entity.Trade;

public interface ITradeService {
    Trade createTrade(Trade trade);

    Trade getTrade(Long tradeId);

    Trade updateTrade(Trade trade);

    void deleteById(Long tradeId);
}
