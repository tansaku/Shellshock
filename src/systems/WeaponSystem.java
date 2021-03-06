package systems;

import infopacks.BulletInfoPack;
import infopacks.WeaponInfoPack;

import java.util.ArrayList;

import components.BulletComponent;
import components.WeaponComponent;

import entities.IEntity;

/**
 * @author Joseph Gefroh
 */
public class WeaponSystem implements ISystem
{
	private Core core;
	
	public WeaponSystem(final Core core)
	{
		this.core = core;
	}
	
	@Override
	public void start() 
	{
	}
	
	
	@Override
	public void work()
	{
		ArrayList<BulletInfoPack> infoPacks 
			= core.getInfoPacksOfType(BulletInfoPack.class);

		for(BulletInfoPack each:infoPacks)
		{
			if(each.getYPos()>=1050||each.getYPos()<=-16)
			{
				destroyBullet(each);
				setReady(each.getBulletOwner());
			}
		}
		
		ArrayList<WeaponInfoPack> weaponPacks 
			= core.getInfoPacksOfType(WeaponInfoPack.class);
		for(WeaponInfoPack each:weaponPacks)
		{
			if(each.isFireRequested()&&each.isReady())
			{
				createBullet(each);
				each.setFireRequested(false);
				each.setReady(false);
			}
			else
			{
				each.setFireRequested(false);
			}
		}
	}
	
	public void createBullet(final WeaponInfoPack each)
	{
		core.getSystem(EntityCreationSystem.class).createBullet(each.getOwner());
	}
	
	private void destroyBullet(final BulletInfoPack each)
	{
		core.removeEntity(each.getOwner());
	}
	@Override
	public void stop()
	{	
	}
	
	public void hit(final IEntity entity, final IEntity entityTwo)
	{
		if(entity.getName().equals("BULLET"))
		{
			setReady(entity.getComponent(BulletComponent.class).getBulletOwner());
		}
		else if(entityTwo.getName().equals("BULLET"))
		{
			setReady(entityTwo.getComponent(BulletComponent.class).getBulletOwner());		
		}
	}
	public void fire(final IEntity entity)
	{
		entity.getComponent(WeaponComponent.class).setFireRequested(true);
	}
	public void setReady(final IEntity entity)
	{
		entity.getComponent(WeaponComponent.class).setReady(true);
	}

}
