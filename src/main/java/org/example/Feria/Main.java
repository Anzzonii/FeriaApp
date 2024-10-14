package org.example.Feria;

import org.example.Feria.Clases.CasetaFeria;
import org.example.Feria.Clases.Feria;
import org.example.Feria.Metodos.MarshallingJSON;
import org.example.Feria.Metodos.MarshallingXML;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Pasamos la lista de casetas creada en el metodo a la clase Feria
        Feria casetas = new Feria(crearCasetas());


        String opcion;
        boolean salir = false;
        MarshallingXML msXML = new MarshallingXML();
        MarshallingJSON msJSON = new MarshallingJSON();

        do{
            System.out.println(
                    "Elige una opción: \n" +
                            "1 Marshalling casetas a XML\n" +
                            "2 Unmarshalling casetas de XML\n" +
                            "3 Mostrar la caseta numero X desde XML\n" +
                            "4 Marshalling casetas a JSON\n" +
                            "5 Unmarshalling casetas de JSON\n" +
                            "6 Mostrar la caseta numero X desde JSON\n" +
                            "7 Salir\n"
            );
            opcion = sc.next();
            switch(opcion){
                case "1":
                    msXML.marshalling(casetas);
                    break;

                case "2":
                    msXML.unmarshalling();
                    break;

                case "3":
                    System.out.println("Id de caseta a mostrar:");
                    int id = sc.nextInt();
                    msXML.mostrarCasetaX(id);
                    break;

                case "4":
                    msJSON.marshalling(casetas);
                    break;

                case "5":
                    msJSON.unmarshalling();
                    break;

                case "6":
                    System.out.println("Id de caseta a mostrar: ");
                    id = sc.nextInt();
                    msJSON.mostrarCasetaX(id);
                    break;

                case "7":
                    salir=true;
                    break;
                default:
            }
        }while(!salir);
    }

    public static List<CasetaFeria> crearCasetas(){
        //Lista en la que meteremos las casetas creadas
        List<CasetaFeria> listaCasetas = new ArrayList<>();

        //Usamos BufferedReader para leer las casetas y meterlas en una lista
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/example/Feria/Archivos/casetas.txt"))){
            String linea;

            int cont = 1;
            //Realizamos un bucle para crear las casetas leyendo cada linea
            while((linea = br.readLine()) != null){

                //Separamos los campos por los guiones
                String[] campos = linea.split(" - ");
                //Creamos cada variable y le introducimos su campo correspondiente
                int id = cont;
                cont++;  //Se le suma para que la id sea el siguiente numero
                String nombre = campos[0];
                String titular = campos[1];
                int aforo = Integer.parseInt(campos[2]);
                String tipoCaseta = campos[3];

                //Añadimos la caseta a la lista
                listaCasetas.add(new CasetaFeria(id, nombre, titular, aforo, tipoCaseta));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listaCasetas;
    }
}
