package org.wheelmap.android.model;

import org.wheelmap.android.model.Wheelmap.POIs;

import wheelmap.org.WheelchairState;
import wheelmap.org.domain.node.Node;
import wheelmap.org.domain.node.Nodes;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

public class DataOperationsNodes extends DataOperations<Nodes, Node> {

	public DataOperationsNodes(ContentResolver resolver) {
		super(resolver);
	}

	@Override
	protected Node getItem(Nodes items, int i) {
		return items.getNodes().get(i);
	}

	@Override
	public void copyToValues(Node node, ContentValues values) {
		values.clear();
		values.put(POIs.WM_ID, node.getId().longValue());
		values.put(POIs.NAME, node.getName());
		values.put(POIs.LATITUDE, Math.ceil(node.getLat().doubleValue() * 1E6));
		values.put(POIs.LONGITUDE, Math.ceil(node.getLon().doubleValue() * 1E6));
		values.put(POIs.STREET, node.getStreet());
		values.put(POIs.HOUSE_NUM, node.getHousenumber());
		values.put(POIs.POSTCODE, node.getPostcode());
		values.put(POIs.CITY, node.getCity());
		values.put(POIs.PHONE, node.getPhone());
		values.put(POIs.WEBSITE, node.getWebsite());
		values.put(POIs.WHEELCHAIR,
				WheelchairState.myValueOf(node.getWheelchair()).getId());
		values.put(POIs.DESCRIPTION, node.getWheelchairDescription());
		values.put(POIs.CATEGORY_ID, node.getCategory().getId().intValue());
		values.put(POIs.NODETYPE_ID, node.getNodeType().getId().intValue());
		values.put(POIs.TAG, POIs.TAG_RETRIEVED);
	}

	@Override
	protected Uri getUri() {
		return POIs.CONTENT_URI_RETRIEVED;
	}

}