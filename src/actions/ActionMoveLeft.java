package actions;

import systems.Core;
import systems.TransformSystem;
import entities.IEntity;

public class ActionMoveLeft implements IAction
{
	private final String command = "MOVE_LEFT";
	private Core core;
	
	public ActionMoveLeft(final Core core)
	{
		this.core = core;
	}

	@Override
	public String getCommand()
	{
		return this.command;
	}

	@Override
	public void execute(final IEntity entity)
	{
		core.getSystem(TransformSystem.class).setXVelocity(entity, -5);
	}

}
