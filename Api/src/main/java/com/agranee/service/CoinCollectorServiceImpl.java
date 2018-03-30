package com.agranee.service;

import com.agranee.domainvalue.CoinTypes;
import com.agranee.exception.CollectorIsFullException;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some driver specific things.
 * <p/>
 */
@Service
public class CoinCollectorServiceImpl implements CoinCollectorService {

    private static final Double MAX_VOLUME = 1.0;

    @Override
    public Integer calculateAmmountAndPrintValues(CoinTypes coinType, Integer totalAmmount) throws InputMismatchException {
        totalAmmount += coinType.getCoinValue();
        return totalAmmount;
    }

    @Override
    public Double calculateVolumeAndPrintValues(CoinTypes coinType, Double volume) throws CollectorIsFullException {
        volume += coinType.getVolume();
        if(volume > MAX_VOLUME){
            throw new CollectorIsFullException("Collector is full");
        }
        return volume;
    }

    @Override
    public String takeCoinsBack(Integer totalAmmount, Double volume) {
        String message = String.format("You took %.2f dollars back", (double)totalAmmount/100);
        return message;
    }
}
