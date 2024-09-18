package br.com.renan.main.domain;

import br.com.renan.main.annotation.TableName;

@TableName("clients")
public class Client implements Persistent {
    public Client() {
    }


    private String uuid;
    private String cpf;
    private String name;
    private String tel;
    private String street;
    private String city;
    private String state;
    private Integer number;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return STR."Client{uuid='\{uuid}', cpf='\{cpf}', name='\{name}', tel='\{tel}', street='\{street}', city='\{city}', state='\{state}', number=\{number}}";
    }
}
