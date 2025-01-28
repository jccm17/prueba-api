package org.sess.dto;

public class DtoCurso {
    private Long id;
    private String nombre;
    private int cupo_maximo;

    public DtoCurso() {
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the nombre
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
     * @return int return the cupo_maximo
     */
    public int getCupo_maximo() {
        return cupo_maximo;
    }

    /**
     * @param cupo_maximo the cupo_maximo to set
     */
    public void setCupo_maximo(int cupo_maximo) {
        this.cupo_maximo = cupo_maximo;
    }

}
