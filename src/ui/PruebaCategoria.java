package ui;

import java.util.Scanner;
import entidades.Categoria;
import logic.ControladorCategoria;

public class PruebaCategoria {

	Scanner scan = null;
	ControladorCategoria cc = null;
	
	public void start() {
		
		scan = new Scanner(System.in);
		cc = new ControladorCategoria();
		String rta = "";
		
		do {
			rta = PruebaCategoria();
			
		switch(rta) {
			case "listar":
				listar();				
				break;
		
			case "buscar":
				buscar();
				break;
		
			case "alta":
				alta();
				break;
		
			case "baja":
				baja();
				break;
		
			case "update":
				update();
				break;
				
			case "exit":
				Menu m = new Menu();
				m.start();
				break;
		
			default:
				System.out.println("error");
				break;
			}

		}while (!rta.equals("exit"));
		
		scan.close();
	}

	private String PruebaCategoria() {
		System.out.println("Ingrese: listar/buscar/alta/baja/update/exit");
		return scan.nextLine();
	}

	private void listar() {
		for(Categoria c: cc.listar()) {
			System.out.println(c);
		}
	}
	private void buscar() {
		Categoria c = new Categoria();
		
		this.listar();
		
		System.out.println("Ingrese el ID a buscar: \n");
		c.setIdCategoria(Integer.parseInt(scan.nextLine()));
		
		if(cc.buscar(c) != null) {
			System.out.println(cc.buscar(c));
		}else System.out.println("404 - Not found"); //DATO DE INTERFAZ
	}
	
	private void alta() { //FALTA LA VALIDACION
		Categoria c = new Categoria();
		System.out.println("Ingrese nombre: \n");
		c.setNombre(scan.nextLine());

		cc.alta(c);
		
		System.out.println("El nuevo ID de marca es: " + c.getIdCategoria());
	}
	
	private void baja() {
		Categoria c = new Categoria(); //Pasar el producto con el id, mejor mantenimiento
		System.out.println("Listado de categorias: ");
		this.listar();
		
		System.out.println("Ingrese el id de la categoria a borrar: ");
		c.setIdCategoria(Integer.parseInt(scan.nextLine()));
		
		cc.baja(c);
		
	}
	
	private void update() {
		Categoria c = new Categoria();
		System.out.println("Listado de categorias: ");
		this.listar();

		System.out.println("Ingrese el id de la categoria a actualizar: ");
		c.setIdCategoria(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Se ingreso la marca: ");
		System.out.println(cc.buscar(c));
		
		System.out.println("Ingrese nombre: ");
		c.setNombre(scan.nextLine());
		
		cc.update(c);
	}
	
}