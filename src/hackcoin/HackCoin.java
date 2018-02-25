
package hackcoin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HackCoin {


    public static void main(String[] args) {
           String StartAmount=null;
           String Prices=null;
           Account acc=null;
         BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(System.in));
          try {
            StartAmount = reader.readLine();
            Prices = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(HackCoin.class.getName()).log(Level.SEVERE, null, ex);
        }
          acc=new Account(Prices.split(","),Double.parseDouble(StartAmount));
          System.out.print(acc.Decisions());
    }
    
}
