package com.ra.service;

import java.util.List;

public interface IGenericService <Entity, Id>{
    List<Entity> getAll();

    boolean save(Entity entity);

    Entity getById(Id entityId);

    boolean update(Entity entity, Id entityId);

    boolean delete(Id entityId);
}
