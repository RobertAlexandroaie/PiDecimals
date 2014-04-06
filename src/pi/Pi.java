/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.io.Console;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class Pi
{
    int decimals;
    BigDecimal val;
    
    /**
     * Constructor
     */
    Pi()
    {
        decimals=0;
        val=new BigDecimal(0.0);
    }
    
    /**
     * 
     * @param s
     * @return true sau false daca string poate fi sau nu un int
     */
    public boolean isInt(String s)
    {        
        try
        {
            Integer.parseInt(s);
        } catch (NumberFormatException e)  
        {
           return false;
         }
        return true;
    }
    
    /**
     * 
     * @param s sirul ce trebuie convertit la int
     */
    public void setDec(String s)
    {
        StringBuilder arg = new StringBuilder(s);
        
        try
        {
            decimals=Integer.parseInt(arg.toString());
        }catch (NumberFormatException e)
                {
                    System.out.println("Valoarea introdusa nu este un numar natural!");
                }
        
        while(!isInt(arg.toString()))
        {
            arg.delete(0, arg.length());
            
            System.out.println("Va rugam introduceti un numar natural:");
            Scanner scan=new Scanner(System.in);
            arg.insert(0,scan.nextLine());
        }
        
        decimals=Integer.parseInt(arg.toString());
    }
    
    
    /**
     * Calculeza pi
     */
    public void setVal()
    {
        BigDecimal x=new BigDecimal(0.0);
        boolean ok=false;
        int i=1;
        BigDecimal k=new BigDecimal(0.0);
        BigDecimal u=new BigDecimal(1.0);
        BigDecimal temp=new BigDecimal(0.0);
        BigDecimal p=new BigDecimal(4);
        
        
        for(i=1;i<=2000000;i++)
        {
            k=new BigDecimal(2*i-1);
            temp=u.divide(k, decimals, BigDecimal.ROUND_FLOOR);
            
            if(i%2==0)
                temp=temp.negate();
            
            x=x.add(temp);
        }
        
        val=x;
        val=val.multiply(p);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        long t1=System.currentTimeMillis();
        
        Pi ob=new Pi();
        ob.setDec(args[0]);
        long t2=System.currentTimeMillis();
        ob.setVal();
        long t3=System.currentTimeMillis();
        
        System.out.println ("Pi="+ob.val.toString());
        System.out.println ("Timpul calcularii lui pi(milisecunde): "+(t3-t2));
        System.out.println ("Timpul executiei programului(milisecunde): "+ (t3-t1));        
    }
}
