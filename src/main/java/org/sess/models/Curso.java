package org.sess.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "curso", schema = "public")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int cupo_maximo;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Alumno> alumnos = new ArrayList<>();
    
    @Transient
    private int totalAlumnos;

    public Curso() {
    }

    public Curso(long id, String nombre, int cupo_maximo, List<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.cupo_maximo = cupo_maximo;
        this.alumnos = alumnos;
    }

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
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
     * @return List<Alumno> return the alumnos
     */
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * @param alumnos the alumnos to set
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + cupo_maximo;
        result = prime * result + ((alumnos == null) ? 0 : alumnos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (cupo_maximo != other.cupo_maximo)
            return false;
        if (alumnos == null) {
            if (other.alumnos != null)
                return false;
        } else if (!alumnos.equals(other.alumnos))
            return false;
        return true;
    }


    /**
     * @return int return the totalAlumnos
     */
    public int getTotalAlumnos() {
        return totalAlumnos;
    }

    /**
     * @param totalAlumnos the totalAlumnos to set
     */
    public void setTotalAlumnos(int totalAlumnos) {
        this.totalAlumnos = totalAlumnos;
    }

}
