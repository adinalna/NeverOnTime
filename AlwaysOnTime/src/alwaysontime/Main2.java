/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alwaysontime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author adina
 */
public class Main2 {
    public static void main(String[] args) {
        DFS dfs = new DFS(15);
	Greedy greedy = new Greedy(15);
        MCT mct2 = new MCT(4,50,15);

	String file = "C:\\Users\\adina\\OneDrive\\Desktop\\UM Assignments\\Year 1 Sem 2\\WIA1002 Data Structure\\sample_AlwaysOnTime.txt"; //path
	ArrayList<Customer> cust = new ArrayList<>();
	try {
		Scanner s = new Scanner(new FileInputStream(file));
		//FileInputStream f = new FileInputStream(file);
		while(s.hasNext()) {
			int x = s.nextInt();
			int y = s.nextInt();
			int demand = s.nextInt();
			int id = s.nextInt();
			cust.add(new Customer(x, y, demand, id));

		}
		s.close();
	}
	catch(FileNotFoundException e) {
		System.out.println("File not found");
	}
	Tour.depot = cust.get(0);
	for(int i = 1; i < cust.size() ; i++) {
		Tour.allCustomer.add(cust.get(i));
	}	

        System.out.println("\n"+mct2.search(4,150).displayMCTS(mct2));
        dfs.rollout();
        greedy.rollout();
    }
}
