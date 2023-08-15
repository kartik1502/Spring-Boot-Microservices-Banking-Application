package org.training.user.service.model.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseMapper<E, D> {

    public abstract E convertToEntity(D dto, Object... args);

    public abstract D convertToDto(E entity, Object... args);

    public Collection<E> convertToEntity(Collection<D> dto, Object... args) {
        return dto.stream().map(d -> convertToEntity(d, args)).collect(Collectors.toList());
    }

    public Collection<D> convertToDto(Collection<E> entities, Object... args) {
        return entities.stream().map(entity ->convertToDto(entity, args)).collect(Collectors.toList());
    }

    public List<E> covertToEntityList(Collection<D> dtos, Object... args) {
        return convertToEntity(dtos, args).stream().collect(Collectors.toList());
    }

    public List<D> convertToDtoList(Collection<E> entities, Object... args) {
        return convertToDto(entities, args).stream().collect(Collectors.toList());
    }

    public Set<E> convertToEntitySet(Collection<D> dtos, Object... args) {
        return convertToEntity(dtos, args).stream().collect(Collectors.toSet());
    }

    public Set<D> convertToDtoSet(Collection<E> entities, Object... args) {
        return convertToDto(entities, args).stream().collect(Collectors.toSet());
    }

}
