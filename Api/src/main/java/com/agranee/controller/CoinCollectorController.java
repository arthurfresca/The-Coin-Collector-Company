package com.agranee.controller;

import com.agranee.domainvalue.CoinTypes;
import com.agranee.exception.CollectorIsFullException;
import com.agranee.service.CoinCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.InputMismatchException;

@RestController
@RequestMapping("v1/coin_collector")
public class CoinCollectorController {

    private final CoinCollectorService coinCollectorService;
    private static Double volume = 0.0;
    private static Integer totalAmount = 0;

    @Autowired
    public CoinCollectorController(final CoinCollectorService coinCollectorService) {
        this.coinCollectorService = coinCollectorService;
    }


    @GetMapping("/{coinType}")
    public HttpStatus addCoin(@Valid @PathVariable CoinTypes coinType) throws CollectorIsFullException {
        volume = coinCollectorService.calculateVolumeAndPrintValues(coinType, volume);
        totalAmount = coinCollectorService.calculateAmmountAndPrintValues(coinType, totalAmount);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/takeCoinsBack")
    public String takeCoinsBack() throws InputMismatchException {
        String message = coinCollectorService.takeCoinsBack(totalAmount, volume);
        volume = 0.0;
        totalAmount = 0;
        return message;
    }


}
