package entities;

import java.util.HashMap;

import components.IComponent;

public class Entity implements IEntity
{
	private HashMap<Class, IComponent> components;	//Uses class type to store
	private boolean hasChanged = false;
	private String name;
	
	public Entity()
	{
		components = new HashMap<Class, IComponent>();
		hasChanged = true;
	}
	
	/**
	 * Add a component of any type
	 * @param type
	 * @param component
	 */
	public <T extends IComponent> void addComponent(Class<T> type, T component)
	{
		components.put(type, (IComponent)component);
		hasChanged = true;
	}
	
	/**
	 * Get the component stored in the hashmap.
	 * @param type	Type is the key used to store the components in the hashmap.
	 * @return		the component that fits the type.
	 */
	public <T>T getComponent(Class<T> type)
	{
		T t = (T)components.get(type);
		if(t!=null)
		{
			return t;
		}
		else
		{
			return null;
		}
	}

	@Override
	public <T> void removeComponent(Class<T> type)
	{
		if(components.get(type)!=null)
		{
			components.remove(type);
		}
		hasChanged = true;
	}
	
	public boolean hasChanged()
	{
		return hasChanged;
	}
	public void setChanged(final boolean hasChanged)
	{
		this.hasChanged = hasChanged;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(final String name)
	{
		this.name = name;
	}
}
