package com.address.repo;

/**
 * User: jules
 * Date: 7/6/14
 */
public interface AbstractRepository<Type> {

    /**
     * Save or update the entity
     *
     * @param entity the entity to save or update
     * @return the updated or saved entity
     */
    Type saveOrUpdate(Type entity);

    /**
     * Save the entity
     *
     * @param entity the entity to save
     * @return the saved entity
     */
    Type save(Type entity);

    /**
     * Update the entity
     *
     * @param entity the entity to update
     * @return the updated entity
     */
    Type update(Type entity);

    /**
     * Delete the entity
     *
     * @param entity the entity to delete
     */
    void delete(Type entity);

    /**
     * Delete the entity  using the Id
     *
     * @param entity the entity to delete
     */
    void deleteById(Long id, Type entity);

}
