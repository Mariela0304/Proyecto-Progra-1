package com.paquete;

public class Negocio {

    static String[][] tiposDeUsuario = new String[][]{{"1", "empleado público", "1"}, {"2", "cliente frecuente", "0.3"}, {"3", "cliente sin registro", " "}};
    static String[][] usuarios = new String[5][4];
    static String[][] registros = new String[5][9];
    static double [] fechas1 = new double[1230];
    static double [] fechas2 = new double[1230];
    static double [] fechas3 = new double[1230];



    static void declaracionUsuario() {

        usuarios[0][0] = "Maria";
        usuarios[0][1] = "Chavez";
        usuarios[0][2] = "ASD-465";
        usuarios[0][3] = "2";

        usuarios[1][0] = "Jose";
        usuarios[1][1] = "Bonilla";
        usuarios[1][2] = "FIJ-904";
        usuarios[1][3] = "2";

        usuarios[2][0] = "Luis";
        usuarios[2][1] = "Soto";
        usuarios[2][2] = "JIH-800";
        usuarios[2][3] = "1";
    }


    static void declaracionRegistros() {

        registros[0][0] = "ASD-465";//PLACA
        registros[0][1] = "8";//HORA DE ENTRADA
        registros[0][2] = "2";//MINUTOS DE ENTRADA
        registros[0][3] = "30";//DIA
        registros[0][4] = "2";//MES
        registros[0][5] = "2018";//AÑO
        registros[0][8] = "8470.0";


        registros[1][0] = "FIJ-904";//PLACA
        registros[1][1] = "9";//HORA DE ENTRADA
        registros[1][2] = "0";//MINUTOS DE ENTRADA
        registros[1][3] = "10";//DIA
        registros[1][4] = "3";//MES
        registros[1][5] = "2018";//AÑO
        registros[1][8] = "2500.0";

        registros[2][0] = "JIH-800";//PLACA
        registros[2][1] = "10";//HORA DE ENTRADA
        registros[2][2] = "45";//MINUTOS DE ENTRADA
        registros[2][3] = "25";//DIA
        registros[2][4] = "3";//MES
        registros[2][5] = "2018";//AÑO;
        registros[2][8] = "4000";

        registros[3][0] = "QWE-123";//PLACA
        registros[3][1] = "12";//HORA DE ENTRADA
        registros[3][2] = "40";//MINUTOS DE ENTRADA
        registros[3][3] = "30";//DIA
        registros[3][4] = "3";//MES5
        registros[3][5] = "2018";//AÑO;
        registros[3][8] = "20000.0";
    }

    static void declaracionfechas1 (){
        fechas1 [230] = 8470.0;
    }
    static void declaracionFechas2 (){
        fechas2 [310] = 2500.0;
        fechas2 [325] = 4000.0;
    }
    static void declaracionFechas3 (){
        fechas3 [330] = 20000.0;
    }

    static void calcularTipo() {

        for (int contIdUsuario = 0; contIdUsuario < usuarios.length; contIdUsuario++) {

            if (usuarios[contIdUsuario][3] != null) {

                if (usuarios[contIdUsuario][3].equals("1")) {
                    usuarios[contIdUsuario][3] = tiposDeUsuario[0][1];

                } else {

                    if (usuarios[contIdUsuario][3].equals("2")) {
                        usuarios[contIdUsuario][3] = tiposDeUsuario[1][1];
                    }
                }
            }
        }
    }


    static void registroEntrada(String pPlaca, String pHoraE, String pMinutosE, String pDia, String pMes, String pAnno) {

        int contR = 0;
        boolean seguir = true;

        while (seguir && contR < registros.length) {

            if (registros[contR][0] == null) {
                registros[contR][0] = pPlaca;
                registros[contR][1] = pHoraE;
                registros[contR][2] = pMinutosE;
                registros[contR][3] = pDia;
                registros[contR][4] = pMes;
                registros[contR][5] = pAnno;
                seguir = false;

            } else {
                seguir = true;
                contR++;
            }

            System.out.print("\n");
        }
    }


    static void imprimirEntrada() {

        for (int contFilaR = 0; contFilaR < registros.length; contFilaR++) {

            if (registros[contFilaR][0] != null) {

                int minutos = Integer.parseInt(registros[contFilaR][2]);
                if (minutos < 10) {
                    System.out.println(registros[contFilaR][0].toUpperCase() + "          " + registros[contFilaR][1] + ":0" + minutos + "           " + registros[contFilaR][3] + "/" + registros[contFilaR][4] + "/" + registros[contFilaR][5]);

                } else {
                    System.out.println(registros[contFilaR][0].toUpperCase() + "          " + registros[contFilaR][1] + ":" + minutos + "            " + registros[contFilaR][3] + "/" + registros[contFilaR][4] + "/" + registros[contFilaR][5]);
                }

            }
            System.out.print("\n");
        }
    }


    static String registroSalida(String pVehículo, String horaSalida, String minutosSalida, String tiquete, int costoxHora) {

        int horasAPagar;
        int minutosAPagar;
        int e = 0;
        int contFRS = 0;
        int horaE;
        int minE;
        int horaS;
        int minS;
        double desc;
        double descTotal;
        double montoAPagar;
        String mTotal = " ";
        boolean seguirRegistros = true;
        boolean seguirUsuarios = true;

        while (seguirRegistros && contFRS < registros.length) {

            if (pVehículo.equals(registros[contFRS][0])) {
                int fecha = Integer.parseInt(registros[contFRS][4]+registros[contFRS][3]);



                registros[contFRS][6] = horaSalida;
                registros[contFRS][7] = minutosSalida;
                horaE = Integer.parseInt(registros[contFRS][1]);
                minE = Integer.parseInt(registros[contFRS][2]);
                horaS = Integer.parseInt(registros[contFRS][6]);
                minS = Integer.parseInt(registros[contFRS][7]);

                while (seguirUsuarios && e < usuarios.length) {

                    if (pVehículo.equals(usuarios[e][2])) {

                        switch (tiquete) {

                            case "si":

                                if (usuarios[e][3].equals(tiposDeUsuario[0][1])) {
                                    montoAPagar = 0;
                                    fechas1 [fecha]+= montoAPagar;
                                    mTotal = Double.toString(montoAPagar);
                                    registros[contFRS][8] = mTotal;
                                    seguirUsuarios = false;
                                    seguirRegistros = false;
                                    break;

                                } else {
                                    horasAPagar = horaS - horaE;
                                    minutosAPagar = minS - minE;

                                    if (minutosAPagar != 0) {
                                        horasAPagar++;
                                    }

                                    desc = Double.parseDouble(tiposDeUsuario[1][2]);
                                    descTotal = costoxHora - (costoxHora * desc);
                                    montoAPagar = descTotal * horasAPagar;
                                    fechas2 [fecha] += montoAPagar;
                                    mTotal = Double.toString(montoAPagar);
                                    registros[contFRS][8] = mTotal;
                                    seguirUsuarios = false;
                                    seguirRegistros = false;

                                    break;
                                }

                            case "no":

                                horasAPagar = horaS;
                                minutosAPagar = minS;

                                if (minutosAPagar != 0) {
                                    horasAPagar++;
                                }

                                if (usuarios[e][3].equals(tiposDeUsuario[0][1])) {

                                    montoAPagar = 0;
                                    fechas1 [fecha] += montoAPagar;
                                    mTotal = Double.toString(montoAPagar);
                                    registros[contFRS][8] = mTotal;
                                    seguirUsuarios = false;
                                    seguirRegistros = false;

                                } else {

                                    desc = Double.parseDouble(tiposDeUsuario[1][2]);
                                    descTotal = costoxHora - (costoxHora * desc);
                                    montoAPagar = descTotal * horasAPagar;
                                    fechas2 [fecha] += montoAPagar;
                                    mTotal = Double.toString(montoAPagar);
                                    registros[contFRS][8] = mTotal;
                                    seguirUsuarios = false;
                                    seguirRegistros = false;
                                }
                                break;

                            default:

                                System.out.println("Error!");
                                seguirUsuarios = true;
                                break;
                        }

                    } else {

                        e++;
                        seguirUsuarios = true;

                    }
                }

                if (e >= usuarios.length && seguirUsuarios) {

                    switch (tiquete) {

                        case "si":

                            horasAPagar = horaS - horaE;
                            minutosAPagar = minS;

                            if (minutosAPagar != 0) {
                                horasAPagar++;
                            }

                            montoAPagar = horasAPagar * costoxHora;
                            fechas3 [fecha] += montoAPagar;
                            mTotal = Double.toString(montoAPagar);
                            registros[contFRS][8] = mTotal;
                            seguirRegistros = false;
                            break;

                        case "no":

                            horasAPagar = horaS;
                            minutosAPagar = minS;

                            if (minutosAPagar != 0) {
                                horasAPagar++;
                            }

                            montoAPagar = horasAPagar * costoxHora;
                            fechas3 [fecha] += montoAPagar;
                            mTotal = Double.toString(montoAPagar);
                            registros[contFRS][8] = mTotal;
                            seguirRegistros = false;
                            break;

                        default:

                            System.out.println("Error!");
                            break;
                    }

                }

            } else {

                contFRS++;

                seguirRegistros = true;
            }
        }


        return mTotal;
    }


    static void imprimirSalida() {
        for (int contFilaR = 0; contFilaR < registros.length; contFilaR++) {
            if (registros[contFilaR][6] != null) {
                int mE = Integer.parseInt(registros[contFilaR][2]);
                int mS = Integer.parseInt(registros[contFilaR][7]);
                if (mE < 10) {
                    if (mS < 10) {
                        System.out.println(registros[contFilaR][0].toUpperCase() + "        " + registros[contFilaR][1] + ":0" + mE + "              " + registros[contFilaR][3] + "/" + registros[contFilaR][4] + "/" + registros[contFilaR][5] + "         " + registros[contFilaR][6] + ":0" + mS + "              ₡" + registros[contFilaR][8] + "\n");
                    } else {
                        System.out.println(registros[contFilaR][0].toUpperCase() + "        " + registros[contFilaR][1] + ":0" + mE + "              " + registros[contFilaR][3] + "/" + registros[contFilaR][4] + "/" + registros[contFilaR][5] + "         " + registros[contFilaR][6] + ":" + mS + "               ₡" + registros[contFilaR][8] + "\n");
                    }
                } else {
                    if (mS < 10) {
                        System.out.println(registros[contFilaR][0].toUpperCase() + "         " + registros[contFilaR][1] + ":" + mE + "              " + registros[contFilaR][3] + "/" + registros[contFilaR][4] + "/" + registros[contFilaR][5] + "           " + registros[contFilaR][6] + ":0" + mS + "              ₡" + registros[contFilaR][8] + "\n");
                    } else {
                        System.out.println(registros[contFilaR][0].toUpperCase() + "         " + registros[contFilaR][1] + ":" + mE + "             " + registros[contFilaR][3] + "/" + registros[contFilaR][4] + "/" + registros[contFilaR][5] + "          " + registros[contFilaR][6] + ":" + mS + "               ₡ " + registros[contFilaR][8] + "\n");
                    }
                    System.out.print("\n");
                }
            }
        }
    }


    static void crearUsuario(String pnombre, String papellido, String pplaca, String piD) {
        int contF = 0;
        boolean seguir = true;
        while (seguir && contF < usuarios.length) {
            if (usuarios[contF][0] == null) {
                usuarios[contF][0] = pnombre;
                usuarios[contF][1] = papellido;
                usuarios[contF][2] = pplaca;
                usuarios[contF][3] = piD;
                calcularTipo();
                seguir = false;
            }
            contF++;
        }
    }


    static void lista() {
        System.out.println("\n\nLista de Usuarios:\n");
        for (int i = 0; i < usuarios.length; i++) {
            if (registros[i][0] != null) {
                for (int j = 0; j < usuarios[i].length; j++) {
                    System.out.print(usuarios[i][j] + "  ");
                }
            }
            System.out.println("\n");
        }
    }


    static double[] reporte(int pFecha) {

        double monto1 = 0;
        double monto2 = 0;
        double monto3 = 0;
        double[] montosTipos;
        montosTipos = new double[3];

        for ( int contFechas = 101; contFechas > 0; contFechas--){
            monto1 += fechas1 [pFecha];
            monto2 += fechas2 [pFecha];
            monto3 += fechas3 [pFecha];
            pFecha--;
        }

        montosTipos [0] = monto1;
        montosTipos [1] = monto2;
        montosTipos [2] = monto3;
        return montosTipos;
    }



}



