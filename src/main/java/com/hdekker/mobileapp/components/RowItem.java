package com.hdekker.mobileapp.components;

import com.hdekker.mobileapp.style.UIStyle;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * 
 * A wrapper for the application row flow
 *
 * @author HDekker
 *
 */
public class RowItem extends HorizontalLayout{
	
	public RowItem(Component component) {
		
		add(component);
		setClassName(UIStyle.ROW_ITEM);
		
	}
	
}
