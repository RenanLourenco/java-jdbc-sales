package br.com.renan.main.repositories;

import br.com.renan.main.domain.Persistent;

import java.util.Collection;

public interface IGenericRepo <T extends Persistent> {
    public Boolean create(T model);
    public void delete(String key);
    public T get(String key);
    public Collection<T> list();
    public T update(String key, T model);
}
