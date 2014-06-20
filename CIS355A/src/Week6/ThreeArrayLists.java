package Week6;

import java.util.ArrayList;

public class ThreeArrayLists {

    public static void main(String[] args) {
        ArrayList<Double> priceList = new ArrayList<Double>();
        ArrayList<Double> quantityList = new ArrayList<Double>();
        ArrayList<Double> amountList = new ArrayList<Double>();
        
        //PRICE lIST
        priceList.add(10.62);
        priceList.add(14.89);
        priceList.add(13.21);
        priceList.add(16.55);
        priceList.add(18.62);
        priceList.add(9.47);
        priceList.add(6.58);
        priceList.add(18.32);
        priceList.add(12.15);
        priceList.add(3.98);
        
        //QUANTITY LIST   
        quantityList.add(4.0);
        quantityList.add(8.5);
        quantityList.add(6.0);
        quantityList.add(7.35);
        quantityList.add(9.0);
        quantityList.add(15.3);
        quantityList.add(3.0);
        quantityList.add(5.4);
        quantityList.add(2.9);
        quantityList.add(4.8);

        extend(amountList, quantityList, priceList);
        displayList(quantityList, priceList, amountList);

    }

    private static void displayList(ArrayList<Double> quantityList, ArrayList<Double> priceList, ArrayList<Double> amountList)  {

        for (int i = 0; i < 10; i++) {
        	double price = priceList.get(i);
        	double quantity = quantityList.get(i);
        	double amount = amountList.get(i);
        	
            System.out.format("%d)  %.2f * %.2f = %.2f \n",i+1,price, quantity, amount);
        }
    }

    private static void extend(ArrayList<Double> amountList, ArrayList<Double> quantityList, ArrayList<Double> priceList) {

        for (int i = 0; i < 10; i++) {
        	double price = (double)priceList.get(i);
        	double quantity = (double)quantityList.get(i);
        	
            amountList.add(price * quantity);
        }

    }
}
