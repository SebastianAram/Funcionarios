package com.iudigital.fun.funcionarios.test;

import com.iudigital.fun.funcionarios.controller.FuncionarioController;
import com.iudigital.fun.funcionarios.domain.Funcionario;

import java.sql.SQLException;
import java.util.List;

import java.util.Scanner;


public class FuncionariosTestConsola {

    public static void crear(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el tipo de identificacion: ");
            String tipo = sc.nextLine();
            System.out.println("El tipo de identificacion es: " + tipo);
            System.out.println("---------------------");

            System.out.println("Digite el numero de identificacion: ");
            String numero = sc.nextLine();
            System.out.println("El numero es: " + numero);
            System.out.println("---------------------");

            System.out.println("Digite los nombres: ");
            String nombres = sc.nextLine();
            System.out.println("Los nombres son: " + nombres);
            System.out.println("---------------------");

            System.out.println("Digite los apellidos: ");
            String apellidos = sc.nextLine();
            System.out.println("Los apellidos son: " + apellidos);
            System.out.println("---------------------");

            System.out.println("Digite el estado civil: ");
            String estado = sc.nextLine();
            System.out.println("El estado civil es: " + estado);
            System.out.println("---------------------");

            System.out.println("Digite el sexo: ");
            String sexo = sc.nextLine();
            System.out.println("El sexo es: " + sexo);
            System.out.println("---------------------");

            System.out.println("Digite la direccion: ");
            String direccion = sc.nextLine();
            System.out.println("La direccion es: " + direccion);
            System.out.println("---------------------");

            System.out.println("Digite el telefono: ");
            String telefono = sc.nextLine();
            System.out.println("El telefono es: " + telefono);
            System.out.println("---------------------");

            System.out.println("Digite la fecha en formato dd/mm/yyyy : ");
            String fecha = sc.nextLine();
            System.out.println("La fecha es: " + fecha);
            System.out.println("---------------------");

            System.out.println("Digite el id del grupo familiar: ");
            int grupof = Integer.parseInt(sc.nextLine());
            System.out.println("El id grupo familiar es: " + grupof);
            System.out.println("---------------------");

            System.out.println("Digite el id de la academia: ");
            int academia = Integer.parseInt(sc.nextLine());
            System.out.println("El id de la academia: " + academia);
            System.out.println("---------------------");

            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion(tipo);
            funcionario.setNumeroIdentificacion(numero);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstadoCivil(estado);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fecha);
            funcionario.setIdGrupo(grupof);
            funcionario.setIdAcademia(academia);
            funcionarioController.crear(funcionario);
            System.out.println("Funcionario creado");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void obtenerFuncionarios(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay datos");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("id: " + funcionario.getId());
                    System.out.println("TipoIdentificacion: " + funcionario.getTipoIdentificacion());
                    System.out.println("NumeroIdentificacion: " + funcionario.getNumeroIdentificacion());
                    System.out.println("Nombres: " + funcionario.getNombres());
                    System.out.println("Apellidos: " + funcionario.getApellidos());
                    System.out.println("EstadoCivil: " + funcionario.getEstadoCivil());
                    System.out.println("Sexo: " + funcionario.getSexo());
                    System.out.println("Direccion: " + funcionario.getDireccion());
                    System.out.println("Telefono: " + funcionario.getTelefono());
                    System.out.println("FechaNacimiento: " + funcionario.getFechaNacimiento());
                    System.out.println("IdGrupo: " + funcionario.getIdGrupo());
                    System.out.println("IdAcademia: " + funcionario.getIdAcademia());
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void eliminar(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el ID del Funcionario a eliminar");
            int id = sc.nextInt();
            System.out.println("El ID del Funcionario eliminado es: " + id);
            Funcionario funcionarioExiste = funcionarioController.obtenerFuncionario(id);
            if (funcionarioExiste == null) {
                System.out.println("No existe el ID ingresado");
                return;
            }

            funcionarioController.eliminarFuncionario(id);
            System.out.println("Funcionario eliminado");
            obtenerFuncionarios(funcionarioController);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {

        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        FuncionarioController funcionarioController = new FuncionarioController();
        while (opcion != 0) {
            System.out.println("--------------------------");
            System.out.println("ELIJA UNA OPCION ");
            System.out.println("--------------------------");
            
            System.out.println("1. Listar Funcionarios ");
            System.out.println("2. Crear Funcionario ");
            System.out.println("3. Eliminar Funcionario ");
            System.out.println("0. Salir ");

            System.out.println("--------------------------");

            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 0:
                    System.out.println("Ha salido exitosamente");
                    break;
                case 1:
                    obtenerFuncionarios(funcionarioController);
                    break;
                case 2:
                    crear(funcionarioController);
                    break;
                case 3:
                    eliminar(funcionarioController);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }
    }
}
