package mx.edu.uacm.alarma.model;

import java.util.Set;

public class SignupRequest {


        private String username;
        private String email;
        private Set<String> role;
        private String password;
        private String nombre;
        private String matricula;
        private String carrera;
        private String plantel;
        private String turno;
        private String urlfoto;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Set<String> getRole() {
            return this.role;
        }

        public void setRole(Set<String> role) {this.role = role;}

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public String getCarrera() {
            return carrera;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }

        public String getPlantel() {
            return plantel;
        }

        public void setPlantel(String plantel) {this.plantel = plantel;}

        public String getTurno() {
            return turno;
        }

        public void setTurno(String turno) {
            this.turno = turno;
        }

        public String getUrlfoto() {
            return urlfoto;
        }

        public void setUrlfoto(String urlfoto) {
            this.urlfoto = urlfoto;
        }

        @Override
        public String toString() {
            return "SignupRequest [username=" + username + ", email=" + email + ", role=" + role + ", password=" + password
                    + ", nombre=" + nombre + ", matricula=" + matricula + ", carrera=" + carrera + ", plantel=" + plantel
                    + ", turno=" + turno + ", urlfoto=" + urlfoto + "]";
        }

    }


