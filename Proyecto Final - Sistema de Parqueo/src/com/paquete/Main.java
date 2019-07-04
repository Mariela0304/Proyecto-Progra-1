package com.paquete;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    static PrintStream salida = System.out;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        String menu;
        boolean seguir = true;
        Negocio.declaracionUsuario();
        Negocio.calcularTipo();
        Negocio.declaracionRegistros();




        do {
            salida.println("1.Registro de entrada\n2.Registro de salida\n3.Creación de usuario\n4.Lista de Usuarios\n5.Reporte\n6.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.next();

            switch (menu) {

                case "1"://registro de entrada

                    registroEntrada();
                    seguir= true;
                    break;

                case "2"://registro de salida

                    registroSalida();
                    seguir=true;
                    break;

                case "3"://creacion de usuarios

                    creacioDeUsuarios();
                    seguir=true;
                    break;

                case "4"://desplegar lista

                    Negocio.lista();
                    seguir = true;
                    break;

                case "5"://reporte de ultimos 30 dias

                    reporte();
                    seguir = true;
                    break;

                case "6"://salir

                    seguir = false;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;

            }

        } while (seguir == true);
    }


    static void registroEntrada() {

        String horaEntrada = " ";
        String minutosEntrada = " ";
        String dia = " ";
        String mes = " ";
        String anno = " ";
        boolean error;
        salida.println("placa");
        String placaR = entrada.next().toUpperCase();

        do {
            salida.println("hora entrada");
            int horaE = entrada.nextInt();
            if (horaE <= 24) {
                horaEntrada = Integer.toString(horaE);
                error = false;
            } else {
                error = true;
            }
        } while (error == true);

        do {

            salida.println("minutos de entrada");
            int minE = entrada.nextInt();
            if (minE <= 59) {
                minutosEntrada = Integer.toString(minE);
                error = false;
            } else {
                error = true;
            }
        } while (error == true);

        do {

            salida.println("dia");
            int numeroDia = entrada.nextInt();
            if (numeroDia <= 30) {
                dia = Integer.toString(numeroDia);
                error = false;
            } else {
                error = true;
            }
        } while (error == true);

        do {
            salida.println("mes");
            int numeroMes = entrada.nextInt();
            if (numeroMes <= 12) {
                mes = Integer.toString(numeroMes);
                error = false;
            } else {
                error = true;
            }
        } while (error == true);

        salida.println("año");
        anno = entrada.next();
        Negocio.registroEntrada(placaR, horaEntrada, minutosEntrada, dia, mes, anno);
        System.out.println("\nPlaca       Hora y MinEntrada    Dia/Mes/Anno\n");
        Negocio.imprimirEntrada();
    }


    static void registroSalida(){
        boolean continuar;
        boolean error;
        String horaSalida = " ";
        String minutosSalida = " ";
        String tiquete = " ";
        int costoPorHora = 1100;
        salida.println("Digite por favor su numero de placa");
        String placaR = entrada.next().toUpperCase();

        do {

            salida.println("\nMencione la hora de su salida");
            int horaS = entrada.nextInt();
            if (horaS <= 24) {
                horaSalida = Integer.toString(horaS);
                error = false;
            } else {
                error = true;
            }

        } while (error);

        do {

            salida.println("\nAnada los minutos de su salida");
            int minS = entrada.nextInt();
            if (minS <= 59) {
                minutosSalida = Integer.toString(minS);
                error = false;
            } else {
                error = true;
            }

        } while (error);


        do {

            salida.println("\nTiene su tiquete?");
            tiquete = entrada.next().toLowerCase();
            switch (tiquete){
                case "si":
                    error = false;
                    break;
                case "no":
                    error = false;
                    break;
                default:
                    salida.println("\nRespuesta invalida");
                    error = true;
                    break;
            }
        }while (error);

        String monto = Negocio.registroSalida(placaR, horaSalida, minutosSalida, tiquete, costoPorHora);
        if (monto.equals(" ")){//arreglar luego
            salida.println("\n\nEste número de placa no se encontró en nuestros registros, será nuevamente redirigido a nuestro menú\n\n");
        }else {
            System.out.println("\nEl monto a pagar es de: ₡" + monto + "\n\n");
            System.out.println("\nPlaca     Hora y Min Entrada    Dia/Mes/Anno    Hora y Min Salida      Monto ");
            Negocio.imprimirSalida();
        }
    }


    static void creacioDeUsuarios (){

        salida.println("\nNombre");
        String nombre = entrada.next();
        salida.println("\nApellido");
        String apellido = entrada.next();
        salida.println("\nPlaca");
        String placa = entrada.next().toUpperCase();
        salida.println("\nID de usuario");
        String iD = entrada.next();
        Negocio.crearUsuario(nombre, apellido, placa, iD);
    }


    static void reporte (){

        boolean error;
        int diaRep;
        int mesRep;
        Negocio.declaracionfechas1();
        Negocio.declaracionFechas2();
        Negocio.declaracionFechas3();
        do {
            salida.println("Digite el dia que desea consultar");
            diaRep = entrada.nextInt();
            if (diaRep <= 30) {
                error = false;
            } else {
                error = true;
            }

        } while (error == true);

        do {
            salida.println("Digite el mes");
            mesRep = entrada.nextInt();
            if (mesRep <= 12) {
                error = false;
            } else {
                error = true;
            }

        } while (error == true);
        String d = Integer.toString(diaRep);
        String m = Integer.toString(mesRep);
        int fechaPedida = Integer.parseInt(m+d);
        double[] ganancias = Negocio.reporte(fechaPedida);
        System.out.println("\n\n Reporte mensual de cada tipo de usuario:\n\n    Ganancias de los empleados publicos: ₡"+ganancias[0]+"\n\n"+"    Ganancias de los clientes frecuentes: ₡"+ganancias[1] +"\n\n"+"    Ganancias de los clientes sin registro: ₡"+ganancias[2]+"\n\n\n");
    }
}


