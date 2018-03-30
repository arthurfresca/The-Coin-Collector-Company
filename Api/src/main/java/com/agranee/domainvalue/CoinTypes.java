package com.agranee.domainvalue;
/*

    Calculations used to calculate the volume of all currencies

    1 - 3,1415 * (9,525/1000)² * (1,52/1000) = 0.000000433222 m³ = 0.014648978 oz
    5 - 3,1415 * (10,605/1000)² * (1,95/1000) = 0.000000688958 m³ = 0.023296441 oz
    10 - 3,1415 * (8,955/1000)² * (1,35/1000) = 0.000000340096 m³ = 0.011500014 oz
    25 - 3,1415 * (12,13/1000)² * (1,75/1000) = 0.000000808903 m³ = 0.027352264 oz
    50 - 3,1415 * (15,305/1000)² * (2,15/1000) = 0.00000158213 m³ = 0.053498179 oz
    100 - 3,1415 * (13,245/1000)² * (2,00/1000) = 0.000001102227 m³ = 0.037270728 oz

    Information got on:
    https://www.usmint.gov/learn/coin-and-medal-programs/coin-specifications
*/

public enum CoinTypes {
    PENNY(1, "Penny", 0.014648978),
    NICKEL(5, "Nickel", 0.023296441),
    DIME(10, "Dime", 0.011500014),
    QUARTER(25, "Quarter", 0.027352264),
    HALF(50, "Half", 0.053498179),
    DOLLAR(100, "Dollar", 0.037270728);

    Integer coinValue;
    Double volume;
    String coinName;

    CoinTypes(Integer coinValue, String coinName, Double volume) {
        this.coinValue = coinValue;
        this.coinName = coinName;
        this.volume = volume;
    }

    public Integer getCoinValue() {
        return coinValue;
    }

    public String getCoinName(){
        return coinName;
    }

    public Double getVolume(){
        return volume;
    }

}
