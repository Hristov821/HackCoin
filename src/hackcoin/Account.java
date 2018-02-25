/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackcoin;

import java.util.ArrayList;

/**
 *
 * @author hrist
 */
public class Account {
    Double Amount=null;
    ArrayList<Double> Prices=new ArrayList<Double>();
    
    
    public Account(String[] strPrices,double Amount) {
        this.setAmount(Amount);
        this.setPrices(strPrices);     
}
    
    public void setPrices(String[] strPrices){
        for(int i=0;i<strPrices.length;i++){
            Prices.add(Double.parseDouble(strPrices[i]));
        }
    }
    public void setAmount(double Amount){
        this.Amount=Amount;
    }
    public Double getAmount(){
        return Amount;
    }
    public String Decisions(){
        StringBuilder decisions=new StringBuilder();
        boolean buy = false;
        double boughtprice = 0;
        double previous = Prices.get(0);
        for(int i=1;i<Prices.size();i++){
            if(previous<Prices.get(i)){
                if(buy==false){
                    decisions.append("buy, ");
                    boughtprice = previous;
                    buy=true;
                }
                else{
                    decisions.append("hold, ");
                }
            }
            else if(previous>Prices.get(i)){
                if(buy==true){
                    buy=false;
                    decisions.append("sell,  ");
                    Amount = Amount * (previous / boughtprice);
                }
                else{
                    decisions.append("hold, ");
                }     
            }
            previous=Prices.get(i);
        }
             if (Prices.get(Prices.size() - 1) - Prices.get(Prices.size() - 2) > 0) {
            Amount = Amount * (Prices.get(Prices.size() - 1) / Prices.get(Prices.size() - 2));
            decisions.append("sell");
        } else {
            decisions.append("hold");
        }
        System.out.printf("%.2f \n", Amount);
        return decisions.toString();
    }
    
   
}
