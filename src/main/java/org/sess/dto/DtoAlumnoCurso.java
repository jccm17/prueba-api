package org.sess.dto;

public class DtoAlumnoCurso {
    private String genero;
    private String curso;
    private Long total;

    public DtoAlumnoCurso() {
    }

    public DtoAlumnoCurso(String genero, String curso, Long total) {
        this.genero = genero;
        this.curso = curso;
        this.total = total;
    }

    /**
     * @return String return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
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
     * @return Long return the total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Long total) {
        this.total = total;
    }

}
