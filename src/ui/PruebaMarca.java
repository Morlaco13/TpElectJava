package ui;

import java.util.Scanner;

import entidades.Marca;
import logic.ControladorMarca;

public class PruebaMarca {

	Scanner scan = null;
	ControladorMarca cm = null;
	
	public void start() {
		
		scan = new Scanner(System.in);
		cm = new ControladorMarca();
		String rta = "";
		
		do {
			rta = PruebaMarca();
	
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

	private String PruebaMarca() {
		System.out.println("Ingrese: listar/buscar/alta/baja/update/exit");
		return scan.nextLine();
	}

	private void listar() {
		for(Marca m: cm.listar()) {
			System.out.println(m);
		}
	}
	private void buscar() {
		Marca m = new Marca();
		
		this.listar();
		
		System.out.println("Ingrese el ID a buscar: \n");
		m.setIdMarca(Integer.parseInt(scan.nextLine()));
		
		if(cm.buscar(m) != null) {
			System.out.println(cm.buscar(m));
		}else System.out.println("404 - Not found"); //DATO DE INTERFAZ
	}
	
	private void alta() { //FALTA LA VALIDACION
		Marca m = new Marca();
		System.out.println("Ingrese nombre: \n");
		m.setNombre(scan.nextLine());

		cm.alta(m);
		
		System.out.println("El nuevo ID de marca es: " + m.getIdMarca());
	}
	
	private void baja() {
		Marca m = new Marca(); //Pasar el producto con el id, mejor mantenimiento
		System.out.println("Listado de marcas: ");
		this.listar();
		
		System.out.println("Ingrese el id de la marca a borrar: ");
		m.setIdMarca(Integer.parseInt(scan.nextLine()));
		
		cm.baja(m);
		
	}
	
	private void update() {
		Marca m = new Marca();
		System.out.println("Listado de marcas: ");
		this.listar();

		System.out.println("Ingrese el id de la marca a actualizar: ");
		m.setIdMarca(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Se ingreso la marca: ");
		System.out.println(cm.buscar(m));
		
		System.out.println("Ingrese nombre: ");
		m.setNombre(scan.nextLine());
		
		cm.update(m);
	}
	
}