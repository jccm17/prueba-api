package org.sess.dto;

public class DtoAlumnoGenero {

    private String genero;
    private Long total;

    public DtoAlumnoGenero() {
    }

    public DtoAlumnoGenero(String genero, Long total) {
        this.genero = genero;
        this.total = total;
    }

    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
