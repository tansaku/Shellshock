package components;

import entities.IEntity;

/**
 * The interface for all components.
 * Components are the data containers for entities.
 * Components hold all of the data that an entity needs.
 * Entities are defined by the data in their components and by what
 * components they have.
 * Components should not have any logic.
 * Components should be pure data.
 * Components should not communicate with other components directly.
 * @author Joseph Gefroh
 */
public interface IComponent
{
	/**
	 * Set up the component with initial default settings.
	 */
	public void init();
	
	/**
	 * Set the owner of this component.
	 * @param owner	a reference to the owner of this component
	 */
	public void setOwner(final IEntity owner);
	
	/**
	 * Get the owner of this component.
	 * @return the owner of this component
	 */
	public IEntity getOwner();
}
