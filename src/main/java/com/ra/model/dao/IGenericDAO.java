package com.ra.model.dao;

import java.util.List;

public interface IGenericDAO<Entity, Id> {
    List<Entity> getAll();

    boolean save(Entity entity);

    Entity getById(Id entityId);

    boolean update(Entity entity, Id entityId);

    boolean delete(Id entityId);
}
