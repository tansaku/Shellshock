package actions;

import systems.Core;
import systems.TransformSystem;
import entities.IEntity;

public class ActionQuit implements IAction
{
	private final String command = "QUIT";
	private Core core;
	
	public ActionQuit(final Core core)
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
		System.exit(0);
	}

}
