package org.sess.dto;

public class DtoCapacidadCurso {
    private String curso;
    private Double porcentajeDisponible;
    private int maximaCapacidad;

    public DtoCapacidadCurso() {
    }
    

    /**
     * @return String return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return int return the maximaCapacidad
     */
    public int getMaximaCapacidad() {
        return maximaCapacidad;
    }

    /**
     * @param maximaCapacidad the maximaCapacidad to set
     */
    public void setMaximaCapacidad(int maximaCapacidad) {
        this.maximaCapacidad = maximaCapacidad;
    }


    /**
     * @return Double return the porcentajeDisponible
     */
    public Double getPorcentajeDisponible() {
        return porcentajeDisponible;
    }

    /**
     * @param porcentajeDisponible the porcentajeDisponible to set
     */
    public void setPorcentajeDisponible(Double porcentajeDisponible) {
        this.porcentajeDisponible = porcentajeDisponible;
    }

}
