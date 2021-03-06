package events;

import systems.Core;
import systems.DamageSystem;
import systems.WeaponSystem;
import entities.IEntity;

/**
 * Interface that describes an event.
 * @author Joseph Gefroh
 *
 */
public class FortHitEvent implements IEvent
{
	private final String EVENT = "COLLISION";
	private Core core;
	
	public FortHitEvent(final Core core)
	{
		this.core = core;
	}
	public boolean check(final String event, final IEntity source, final IEntity target)
	{
		if(event.equals(EVENT)
				&&(source.getName().equals("BULLET")
				&&target.getName().equals("FORT")))
		{
					return true;
		}
		return false;
	}
	public void execute(final IEntity source, final IEntity target)
	{
		core.getSystem(WeaponSystem.class).hit(source, target);
		core.getSystem(DamageSystem.class).damage(1, source, target);
		core.removeEntity(source);
	}
}
