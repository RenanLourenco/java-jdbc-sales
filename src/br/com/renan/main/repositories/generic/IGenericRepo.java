package br.com.renan.main.repositories.generic;

import br.com.renan.main.domain.Persistent;

import java.util.Collection;

public interface IGenericRepo <T extends Persistent> {
    public T create(T model);
    public Boolean delete(String key);
    public T get(String key);
    public Collection<T> list();
    public T update(String key, T model);
}
