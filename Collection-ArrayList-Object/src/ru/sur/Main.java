package ru.sur;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	private static ArrayList<Mobile> mobile = new ArrayList<Mobile>();
	private static Random r = new Random();
	
	public static void main(String[] args) {
		for(int i=0;i<300;i++) {
			mobile.add(new Mobile(r.nextInt(999999),"LG"));
		}
		for(Mobile m: mobile) {
			
			System.out.println(m.getNamber()+" "+m.getName());
			
		}
		}

	}
