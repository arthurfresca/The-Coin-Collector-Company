package com.agranee.service;

import com.agranee.domainvalue.CoinTypes;
import com.agranee.exception.CollectorIsFullException;

public interface CoinCollectorService {
    Integer calculateAmmountAndPrintValues(CoinTypes coinType, Integer totalAmmount);
    Double calculateVolumeAndPrintValues(CoinTypes coinType, Double volume) throws CollectorIsFullException;
    String takeCoinsBack(Integer totalAmmount, Double volume);
}
