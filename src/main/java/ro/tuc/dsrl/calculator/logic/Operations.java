package ro.tuc.dsrl.calculator.logic;

import ro.tuc.dsrl.calculator.models.Polynomial;
import java.util.HashMap;
import java.util.Map;

public class Operations {

    public Polynomial add(Polynomial firstNumber, Polynomial secondNumber) {
        String r = "";
        Number ad;

        System.out.println(firstNumber.getMonomials().get(2).intValue() + " __ " + secondNumber.getMonomials().get(2).intValue());

        Polynomial result = new Polynomial();
        for(Integer degree: firstNumber.getMonomials().keySet()){
            ad = firstNumber.getMonomials().get(degree).intValue() + secondNumber.getMonomials().get(degree).intValue();
            result.getMonomials().put(degree, ad);
        }

        System.out.println("RESULT");
        System.out.println(r);
        return result;
    }

    public Polynomial subtract(Polynomial firstNumber, Polynomial secondNumber) {
        Number ad;

        System.out.println(firstNumber.getMonomials().get(2).intValue() + " __ " + secondNumber.getMonomials().get(2).intValue());

        Polynomial result = new Polynomial();

        for(Integer degree: firstNumber.getMonomials().keySet()){
            ad = firstNumber.getMonomials().get(degree).intValue() - secondNumber.getMonomials().get(degree).intValue();
            result.getMonomials().put(degree, ad);
        }

        System.out.println("RESULT");
        return result;
    }

    public Polynomial multiply(Polynomial firstNumber, Polynomial secondNumber) {
        Polynomial result=firstNumber;
        return result;
    }
}
