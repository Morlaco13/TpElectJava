package ui;

import java.util.Scanner;

import entidades.Persona;
import logic.ControladorPersona;

public class PruebaPersona {

	Scanner scan = null;
	ControladorPersona cp = null;
	
	public void start() {
		
		scan = new Scanner(System.in);
		cp = new ControladorPersona();
		String rta = "";
		
		do {
			rta = PruebaPersona();
	
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

	private String PruebaPersona() {
		System.out.println("Ingrese: listar/buscar/alta/baja/update/exit");
		return scan.nextLine();
	}

	private void listar() {
		for(Persona p: cp.listar()) {
			System.out.println(p);
		}
	}
	private void buscar() {
		Persona p = new Persona();
		
		this.listar();
		
		System.out.println("Ingrese el ID a buscar: \n");
		p.setIdPersona(Integer.parseInt(scan.nextLine()));
		
		if(cp.buscar(p) != null) {
			System.out.println(cp.buscar(p));
		}else System.out.println("404 - Not found"); //DATO DE INTERFAZ
	}
	
	private void alta() { //FALTA LA VALIDACION
		Persona per = new Persona();
		System.out.println("Ingrese nombre: \n");
		per.setNombre(scan.nextLine());
		System.out.println("Ingrese Apellido: \n");
		per.setApellido(scan.nextLine());
		System.out.println("Ingrese DNI: \n");
		per.setDni(Integer.parseInt(scan.nextLine()));
		System.out.println("Ingrese telefono: \n");
		per.setTelefono(Integer.parseInt(scan.nextLine()));
		System.out.println("Ingrese direccion: \n");
		per.setDireccion(scan.nextLine());
		System.out.println("Ingrese Email: \n");
		per.setEmail(scan.nextLine());
		System.out.println("Ingrese si el usuario es Admin(1) o no (0): \n");
		per.setEsAdmin(Boolean.parseBoolean(scan.nextLine()));

		cp.alta(per);
		
		System.out.println("El nuevo ID de usuario es: " + per.getIdPersona());
	}
	
	private void baja() {
		Persona per = new Persona(); //Pasar el producto con el id, mejor mantenimiento
		System.out.println("Listado de Usuarios: ");
		this.listar();
		
		System.out.println("Ingrese el id del usuario a borrar: ");
		per.setIdPersona(Integer.parseInt(scan.nextLine()));
		
		cp.baja(per);
		
	}
	
	private void update() {
		Persona per = new Persona();
		System.out.println("Listado de usuarios: ");
		this.listar();

		System.out.println("Ingrese el id del usuario a actualizar: ");
		per.setIdPersona(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Se ingreso el usuario: ");
		System.out.println(cp.buscar(per));
		
		System.out.println("Ingrese nombre: ");
		per.setNombre(scan.nextLine());
		System.out.println("Ingrese apellido: ");
		per.setApellido(scan.nextLine());
		System.out.println("Ingrese DNI: ");
		per.setDni(Integer.parseInt(scan.nextLine()));
		System.out.println("Ingrese telefono: ");
		per.setTelefono(Integer.parseInt(scan.nextLine()));
		System.out.println("Ingrese direccion: ");
		per.setDireccion(scan.nextLine());
		System.out.println("Ingrese email: ");
		per.setEmail(scan.nextLine());
		System.out.println("Ingrese si el usuario es Admin (1) o no (0): ");
		per.setEsAdmin(Boolean.parseBoolean(scan.nextLine()));
		
		cp.update(per);
	}
	
}
