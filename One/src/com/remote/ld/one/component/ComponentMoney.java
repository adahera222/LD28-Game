package com.remote.ld.one.component;

import java.util.ArrayList;

import com.remote.remote2d.engine.entity.Entity;
import com.remote.remote2d.engine.entity.component.Component;
import com.remote.remote2d.engine.logic.ColliderBox;
import com.remote.remote2d.engine.logic.Vector2;

public class ComponentMoney extends Component {
	
	public Entity player;
	public int amount = 100;

	@Override
	public void init() {
		
	}

	@Override
	public void onEntitySpawn() {
		
	}

	@Override
	public void renderAfter(boolean arg0, float arg1) {
		
	}

	@Override
	public void renderBefore(boolean arg0, float arg1) {
		
	}

	@Override
	public void tick(int arg0, int arg1, int arg2) {
		ArrayList<ComponentPlayer> comps = player.getComponentsOfType(ComponentPlayer.class);
		ColliderBox coll;
		if(comps.size() > 0)
			coll = player.pos.add(comps.get(0).colliderPos).getColliderWithDim(comps.get(0).colliderDim);
		else
			coll = player.pos.getColliderWithDim(player.dim);
		
		if(coll.getCollision(entity.pos.getColliderWithDim(entity.dim), new Vector2(0,0)).collides && comps.size() > 0)
		{
			comps.get(0).addMoney(amount);
			map.getEntityList().removeEntityFromList(entity);
		}
	}

	@Override
	public void apply() {
		
	}

}
