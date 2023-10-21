package ui;

import java.util.Scanner;

public class Menu {
	
	Scanner scan = null;
	
	public void start() {
		scan = new Scanner(System.in);
		String resp = "";
		
		do {
			resp = menu().toLowerCase();
			
		switch(resp) {
			case "categoria":
				PruebaCategoria c = new PruebaCategoria();
				c.start();
				break;
		
			case "marca":
				PruebaMarca m = new PruebaMarca();
				m.start();
				break;
		
			case "persona":
				PruebaPersona p = new PruebaPersona();
				p.start();
				break;
		
			case "producto":
				PruebaProducto p1 = new PruebaProducto();
				p1.start();
				break;
				
			case "exit":
				
				break;
		
			default:
				System.out.println("error");
				break;
			}
	}while (!resp.equals("exit"));
		
		scan.close();
	}
	
	private String menu() {
		
		System.out.println("Ingrese: categoria/marca/persona/producto");
		
		return scan.nextLine();	
	}
	
}
