package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        String line;
        while (!(line = in.nextLine()).equals("")){
            String[] param = line.split(" ");
            String usrName = param[0],
                    prdctName = param[1],
                    countNew = param[2];

            TreeMap<String, Integer> basket = null;
            if (users.containsKey(usrName)){
                basket = users.get(usrName);
            } else {
                basket = new TreeMap<>();
                users.put(usrName, basket);
            }

            Integer countOld = null;
            if (basket != null && basket.containsKey(prdctName)){
                countOld = basket.get(prdctName);
                basket.remove(prdctName);
                basket.put(prdctName, countOld + Integer.parseInt(countNew));
            } else if (basket != null) {
                basket.put(prdctName, Integer.parseInt(countNew));
            }
        }

        for (Map.Entry<String, TreeMap<String, Integer>> user : users.entrySet()){
            System.out.println(user.getKey() + ":");
            for (Map.Entry<String, Integer> prod : user.getValue().entrySet()){
                System.out.println(prod.getKey() + " " + prod.getValue());
            }
        }

    }
}