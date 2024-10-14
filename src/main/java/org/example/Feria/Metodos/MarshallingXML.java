package org.example.Feria.Metodos;

import org.example.Feria.Clases.CasetaFeria;
import org.example.Feria.Clases.Feria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MarshallingXML {

    private final String rutaXML = "src/main/java/org/example/Feria/Archivos/feria.xml";

    public void marshalling(Feria feria){
        try {
            //Creación de conexto JAXB para la clase Feria
            JAXBContext jaxbContext = JAXBContext.newInstance(Feria.class);

            //Creación del marshaller
            Marshaller marshaller =jaxbContext.createMarshaller();

            // Formatear el XML para que sea mas legible
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Serializar el objeto a un fichero xml
            marshaller.marshal(feria, new File(rutaXML));

            System.out.println("Xml creado correctamente");


        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void unmarshalling(){
        //Comprobamos si el archivo xml existe
        if(new File(rutaXML).exists()){
            try {

                //Creamos el contexto JAXB para la clase feria
                JAXBContext jaxbContext = JAXBContext.newInstance(Feria.class);

                //Creamos el unmashaller para deserializar el archivo
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

                //Deserializamos el archivo xml y lo mostramos por pantalla
                Feria feria = (Feria) unmarshaller.unmarshal(new File(rutaXML));

                System.out.println(feria.toString());

            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("No existe el fichero xml, realiza primero la opción 1 para crearlo");
        }
    }

    public void mostrarCasetaX(int id){
        if(new File(rutaXML).exists()) {
            Feria feria;
            try {

                //Creacion del contexto JAXB para la clase feria
                JAXBContext jaxbContext = JAXBContext.newInstance(Feria.class);

                //Deserialización del archivo xml
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                feria = (Feria) unmarshaller.unmarshal(new File(rutaXML));

            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }

            //Buscamos la caseta por la id y la mostramos por pantalla
            for (CasetaFeria cf : feria.getCasetas()) {
                if (cf.getId() == id) {
                    System.out.println(cf);
                }
            }
        }else{
            System.out.println("No existe el fichero xml realiza primero la opción 1 para crearlo");
        }
    }
}
