package ro.tuc.dsrl.calculator.models;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private Map<Integer,Number> monomials = new HashMap<Integer,Number>();

    public void setMonomials(Map<Integer, Number> monomials) {
        this.monomials = monomials;
    }
    public Map<Integer, Number> getMonomials() {
        return monomials;
    }
    public void ppPrint(){
        for(Integer degree: this.monomials.keySet()){
            System.out.println(degree + ": " + this.monomials.get(degree).intValue());
        }
    }
    public String preetyPrint(){
        String result = "";
        for(Integer degree: this.monomials.keySet()){
            if(!this.getMonomials().get(degree).equals(0)){
                if(degree==0){
                    result = result + " (" + Integer.toString(this.getMonomials().get(degree).intValue())+ ") ";
                }
                if(degree==1){
                    result = result + " +(" + Integer.toString(this.getMonomials().get(degree).intValue())+ "x) ";
                }
                if(degree>=2){
                    result = result + " +(" + Integer.toString(this.getMonomials().get(degree).intValue())+ "x^" + degree + ") ";
                }
            }
        }
        return result;
    }
    public void complete(){
        for(int i=0;i<=10;i++){
            this.getMonomials().putIfAbsent(i,0);
        }
    }
}
