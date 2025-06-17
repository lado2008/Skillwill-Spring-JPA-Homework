package com.example.Skillwill_Spring_.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "base_country", nullable = false, length = 50)
    private String country;

    @Column(name = "team_principal", length = 100)
    private String principal;

    @Column(name = "championships_won")
    private int titles;

    @Column(name = "engine_supplier", length = 50)
    private String engine;

    public void setName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public void setCountry(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCountry'");
    }

    public void setPrincipal(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrincipal'");
    }

    public void setTitles(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitles'");
    }

    public void setEngine(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEngine'");
    }

}
