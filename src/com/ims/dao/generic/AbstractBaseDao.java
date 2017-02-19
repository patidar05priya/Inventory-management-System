package com.ims.dao.generic;

/**
 * 
 *  
 * @param <Pk>
 * @param <Entity>
 */
public abstract class AbstractBaseDao<Pk, Entity> implements IBaseDao<Pk, Entity> {
	
	/**
	 * represents the Class of entity. 
	 */
	private Class<Entity> type;
/**
	 * @param type
	 */
	protected AbstractBaseDao(Class<Entity> type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see com.inn.redesign.dao.IBaseDao#find(com.inn.redesign.dao.QueryObject)
	 */
	public Class<Entity> getType() {
		return type;
	}

	public void setType(Class<Entity> type) {
		this.type = type;
	}
}

