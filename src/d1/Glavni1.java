package d1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Glavni1 {
	public static void main(String[] args) {
		System.out.println("AoC24 day 1");

		ArrayList<String> linije =  ucitaj("src/d1/input.txt");
		ArrayList<Integer> brojevi = nadjiBrojeve(linije);
		
		for(int i =0; i< linije.size(); i++) {
			System.out.println(linije.get(i) +" :::"+ brojevi.get(i)  );
		}
		
		int resenje  = brojevi.stream().reduce(0, Integer::sum);

		System.out.println(resenje);
		
		System.out.println("/n================================================/n");
		
		int resenje2 =0;
		
		for (Integer integer : brojevi) {
			
			resenje2 += integer;
		}
		
		System.out.println("resenje2: " + resenje2);
		
		System.out.println("Done");
		

	}

	public static ArrayList<String> ucitaj(String path) {
		String red;
		ArrayList<String> rez = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			while ((red = br.readLine()) != null) {
//				System.out.println("RED::: " + red);
				rez.add(red);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fajl nije dobro unet");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return rez;
	}

	public static ArrayList<Integer> nadjiBrojeve(ArrayList<String> redovi){
		ArrayList<Integer> rez = new ArrayList<Integer>();
		
		int prvi, poslednji;
		
		for(String red : redovi) {
			
			int prva = prvaCifra(red);
			int poslednja  = posednjaCifra(red);
			rez.add( prva*10+ poslednja );
			
		}
		return rez;
	}

	public static int prvaCifra(String s) {
		for(int i =0; i <s.length(); i++) {
			if(Character.isDigit( s.charAt(i))) {
				return Character.getNumericValue(s.charAt(i)); 
			}
		}
		return -1;
	}
	
	public static int posednjaCifra(String s) {
		for(int i =s.length()-1; i >= 0; i--) {
			if(Character.isDigit( s.charAt(i))) {
				return Character.getNumericValue(s.charAt(i)); 
			}
		}
		return -1;
	}
	
	
}
