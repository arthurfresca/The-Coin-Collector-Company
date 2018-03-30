package com.agranee;

import com.agranee.domainValue.CoinTypes;

import java.nio.BufferOverflowException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoinCollectorCompany {

    private static final Double MAX_VOLUME = 1.0;
    private static Boolean isFull = false;

    public static void main(String[] args) {
        inputData();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        Integer coinValue = 0;
        Integer totalAmmount = 0;
        Double volume = 0.0;

        while(coinValue != -1){
            try {
                if(!isFull) {
                    System.out.println("Type a coin value in cents (Options: 1, 5, 10, 25, 50, 100), 0 to get all Money back or -1 to exit");
                }
                coinValue = sc.nextInt();
                volume = calculateVolumeAndPrintValues(coinValue, volume);
                totalAmmount = calculateAmmountAndPrintValues(coinValue, totalAmmount);
            }catch (InputMismatchException e){
                System.out.print("Invalid Value. ");
            } catch(BufferOverflowException e){
                isFull = true;
                System.out.println("Coin Collector is full. Press 0 to get all money back");
            }
        }

    }

    private static Integer calculateAmmountAndPrintValues(Integer coinValue, Integer totalAmmount) {
        if(coinValue == 0){
            isFull = false;
            System.out.println("You got "+((double)totalAmmount/100)+" Dollars. You can save more money again\n");
            totalAmmount = 0;
        } else {
            CoinTypes.isValidValue(coinValue);
            totalAmmount += coinValue;
        }
        return totalAmmount;
    }

    private static Double calculateVolumeAndPrintValues(Integer coinValue, Double volume) {
        if(coinValue == 0){
            volume = 0.0;
        } else {
            volume += CoinTypes.coinVolume(coinValue);
            if(volume > MAX_VOLUME){
                throw new BufferOverflowException();
            }
            System.out.print(volume);
        }
        return volume;
    }
}