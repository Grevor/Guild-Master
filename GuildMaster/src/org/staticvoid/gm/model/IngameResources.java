package org.staticvoid.gm.model;
import org.staticvoid.collections.ArrayIterable;
import org.staticvoid.collections.fixedstorage.BasicFixedKeyStorage;


public class IngameResources extends BasicFixedKeyStorage<IngameResource> {

	public IngameResources() {
		super(Double.POSITIVE_INFINITY);
	}

	@Override
	protected int getIndex(IngameResource key) {
		return key.ordinal();
	}

	@Override
	public Iterable<IngameResource> keyValues() {
		return new ArrayIterable<>(IngameResource.values());
	}

}
