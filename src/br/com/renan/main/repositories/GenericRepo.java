package br.com.renan.main.repositories;

import br.com.renan.main.annotation.TableName;
import br.com.renan.main.domain.Persistent;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class GenericRepo<T extends Persistent> implements IGenericRepo<T>{
    private Connection dbConnection;
    private String tableName;
    private Class<T> type;

    public GenericRepo(Connection c, String t, Class<T> typeClass){
        dbConnection = c;
        tableName = t;
        type = typeClass;
    }

    @Override
    public Boolean create(T model) {
        Class<?> modelClass = model.getClass();

        if(modelClass.isAnnotationPresent(TableName.class)){
            TableName tableNameAnnotation = modelClass.getAnnotation(TableName.class);
            String tableName = tableNameAnnotation.value();


            List<String> fieldsToQuery = new ArrayList<>();
            List<String> quantityValues = new ArrayList<>();
            List<Object> fieldValues = new ArrayList<>();

            for(Field field: modelClass.getDeclaredFields()){
                if(field.getName().equals("uuid") || field.getName().equals("id")){
                    continue;
                }
                fieldsToQuery.add(field.getName());
                quantityValues.add("?");
                field.setAccessible(true);
                try {
                    fieldValues.add(field.get(model)); // Get the actual value of the field from the model instance
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


            String queryFields = String.join(",", fieldsToQuery);
            String queryValues = String.join(",", quantityValues);

            String query = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, queryFields, queryValues);

            try (PreparedStatement statement = dbConnection.prepareStatement(query)) {
                for (int i = 0; i < fieldValues.size(); i++) {
                    Object value = fieldValues.get(i);

                    if (value instanceof String) {
                        statement.setString(i + 1, (String) value);
                    } else if (value instanceof Integer) {
                        statement.setInt(i + 1, (Integer) value);
                    } else if (value instanceof Long) {
                        statement.setLong(i + 1, (Long) value);
                    } else {
                        statement.setObject(i + 1, value);
                    }

                }

                statement.executeUpdate();
                return true;
            } catch (SQLException e) {

                e.printStackTrace();
                throw new RuntimeException(e);

            }

        }

        return false;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public T get(String key) {
        return null;
    }

    @Override
    public Collection<T> list() {
        List<T> results = new ArrayList<>();
        String query = String.format("SELECT * FROM %s", tableName);

        try (PreparedStatement statement = dbConnection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()){


            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                T instance = type.getDeclaredConstructor().newInstance();
                for (int i = 1; i <= columnCount ; i++) {
                    String columnName = resultSet.getMetaData().getColumnName(i);
                    Object value = resultSet.getObject(i);

                    Field field = getFieldByName(type, columnName);
                    if (field != null) {
                        field.setAccessible(true);
                        if (field.getType().equals(String.class) && value instanceof UUID) {
                            field.set(instance, value.toString());
                        } else {
                            field.set(instance, value);
                        }
                    }
                }
                results.add(instance);
            }

            } catch (SQLException | ReflectiveOperationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return results;
    }


    private Field getFieldByName(Class<?> clazz, String fieldName) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }
}
