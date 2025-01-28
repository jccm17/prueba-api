package org.sess.dto;

public class DtoPromedioCurso {
    private String curso;
    private Double promedio;
    private int maximaCapacidad;

    public DtoPromedioCurso() {
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
     * @return Double return the promedio
     */
    public Double getPromedio() {
        return promedio;
    }

    /**
     * @param promedio the promedio to set
     */
    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

}
