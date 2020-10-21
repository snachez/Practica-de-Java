package javaapplication9;
import java.io.Serializable;
import javax.swing.*;

public class ClassArreglos implements Serializable {
    //atributos
    private String codigo;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int DNI;
    private int casa;
    private int celular;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
   
   
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the DNI
     */
    public int getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    /**
     * @return the casa
     */
    public int getCasa() {
        return casa;
    }

    /**
     * @param casa the casa to set
     */
    public void setCasa(int casa) {
        this.casa = casa;
    }

    /**
     * @return the celular
     */
    public int getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }

    
}
