package ui;

import java.util.Scanner;
import entidades.Producto;
import logic.ControladorProducto;

public class Menu {
	Scanner scan = null;
	ControladorProducto cp = null;
	
	public void start() {
		
		scan = new Scanner(System.in);
		cp = new ControladorProducto();
		String rta = "";
		
		do {
			rta = menu();
	
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
				
				break;
		
			default:
				System.out.println("error");
				break;
			}

		}while (!rta.equals("exit"));
		
		scan.close();
	}

	private String menu() {
		System.out.println("Ingrese: listar/buscar/alta/baja/update");
	
	
		return scan.nextLine();
	}

	private void listar() {
		for(Producto p: cp.listar()) {
			System.out.println(p);
		}
	}
	private void buscar() {
		Producto p = new Producto();
		System.out.println("Ingrese el ID a buscar: \n");
		p.setIdProducto(Integer.parseInt(scan.nextLine()));
		
		if(cp.buscar(p) != null) {
			System.out.println(cp.buscar(p));
		}else System.out.println("404 - Not found"); //DATO DE INTERFAZ
	}
	
	private void alta() { //FALTA LA VALIDACION
		Producto prod = new Producto();
		System.out.println("Ingrese nombre: \n");
		prod.setNombre(scan.nextLine());
		System.out.println("Ingrese descripcion: \n");
		prod.setDescripcion(scan.nextLine());
		System.out.println("Ingrese precio: \n");
		prod.setPrecio(Integer.parseInt(scan.nextLine()));
		System.out.println("Ingrese stock: \n");
		prod.setStock(Integer.parseInt(scan.nextLine()));

		cp.alta(prod);
		
		System.out.println("Se el nuevo ID de producto es: " + prod.getIdProducto());
	}
	
	private void baja() {
		Producto prod = new Producto(); //Pasar el producto con el id, mejor mantenimiento
		System.out.println("Listado de productos: ");
		this.listar();
		
		System.out.println("Ingrese el id del producto a borrar: ");
		prod.setIdProducto(Integer.parseInt(scan.nextLine()));
		
		cp.baja(prod);
		
	}
	
	private void update() {
		Producto prod = new Producto();
		System.out.println("Listado de productos: ");
		this.listar();

		System.out.println("Ingrese el id del producto a actualizar: ");
		prod.setIdProducto(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Se ingreso el producto: ");
		System.out.println(cp.buscar(prod));
		
		System.out.println("Ingrese nombre: ");
		prod.setNombre(scan.nextLine());
		System.out.println("Ingrese descripcion: ");
		prod.setDescripcion(scan.nextLine());
		System.out.println("Ingrese precio: ");
		prod.setPrecio(Integer.parseInt(scan.nextLine()));
		System.out.println("Ingrese stock: ");
		prod.setStock(Integer.parseInt(scan.nextLine()));
		
		cp.update(prod);
	}
}
