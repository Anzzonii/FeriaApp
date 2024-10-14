package org.example.Feria.Clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "feria")
public class Feria {
    @XmlElement(name = "caseta")
    private List<CasetaFeria> casetas;

    //Constructor sin argumentos necesario
    public Feria(){}

    public Feria(List<CasetaFeria> casetas) {
        this.casetas = casetas;
    }

    public List<CasetaFeria> getCasetas() {
        return casetas;
    }

    @Override
    public String toString() {
        return "Feria{" +
                "casetas=" + casetas +
                '}';
    }
}
