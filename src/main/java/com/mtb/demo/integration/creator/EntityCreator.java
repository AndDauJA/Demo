package com.mtb.demo.integration.creator;

/**
 * Marker interface for entity creators
 *
 * @param <E> Entity
 * @param <D> Domain
 */
public interface EntityCreator<E, D> {
    E createFromDomain(final D domain);
}
