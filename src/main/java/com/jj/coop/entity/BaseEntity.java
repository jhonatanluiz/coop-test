package com.jj.coop.entity;

import java.io.Serializable;

public abstract class BaseEntity<T extends Serializable> implements Serializable {
	private static final long serialVersionUID = 6832738074913467064L;

	public abstract T getId();

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof BaseEntity))
			return false;
		BaseEntity<?> that = (BaseEntity<?>) o;
		return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	@Override
	public String toString() {
		String entidade = this.getClass().getSimpleName();
		return "Entidade [ " + entidade + " ] {" + "id=" + getId() + '}';
	}

}
