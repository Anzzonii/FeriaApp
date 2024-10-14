package org.example.Feria.Metodos;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Feria.Clases.CasetaFeria;
import org.example.Feria.Clases.Feria;

import java.io.File;
import java.io.IOException;

public class MarshallingJSON {
    private final String rutaJson = "src/main/java/org/example/Feria/Archivos/feria.json";

    public void marshalling(Feria feria){
        try {
            //Creamos el objeto para convertir objetos java a archivos json
            ObjectMapper objectMapper = new ObjectMapper();

            //Serializamos el objeto feria en un archivo json
            objectMapper.writeValue(new File(rutaJson), feria);

            System.out.println("Archivo JSON creado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void unmarshalling(){
        if(new File(rutaJson).exists()) {
            try {
                //Creación de objeto para convertir java a archivos json y al contrario
                ObjectMapper objectMapper = new ObjectMapper();

                //Deserialización del archivo json en objetos de tipo CasetaFeria
                Feria feria = objectMapper.readValue(new File(rutaJson), Feria.class);

                //Mostrar por pantalla los objetos deserializados
                System.out.println(feria.toString());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("No existe el fichero json, ejecuta primero la opción 4 para crearlo");
        }
    }

    public void mostrarCasetaX(int id){
        if(new File(rutaJson).exists()) {
            Feria feria;
            try {
                //Creación de objeto para convertir java a archivos json y al contrario
                ObjectMapper objectMapper = new ObjectMapper();

                //Deserialización del archivo json en objetos de tipo CasetaFeria
                feria = objectMapper.readValue(new File(rutaJson), Feria.class);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Buscamos la caseta por id y la mostramos por pantalla
            for(CasetaFeria caseta : feria.getCasetas()){
                if(caseta.getId()==id){
                    System.out.println(caseta);
                }
            }
        }else{
            System.out.println("No existe el fichero json, ejecuta primero la opción 4 para crearlo");
        }

    }
}
