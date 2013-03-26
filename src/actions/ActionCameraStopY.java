package actions;

import components.VelocityComponent;

import systems.Core;
import systems.MovementSystem;
import entities.IEntity;

public class ActionCameraStopY implements IAction
{
	private String command;
	private Core core;
	private ActionCameraStopY()
	{
		
	}
	public ActionCameraStopY(final Core core, final String command)
	{
		this.core = core;
		setCommand(command);
	}
	@Override
	public void setCommand(final String command)
	{
		this.command = command;
	}

	@Override
	public String getCommand()
	{
		return this.command;
	}
	
	public void execute(final IEntity entity)
	{
		VelocityComponent vc = entity.getComponent(VelocityComponent.class);
		if(vc!=null)
		{			
			vc.setYVelocity(0);
		}
	}

}
