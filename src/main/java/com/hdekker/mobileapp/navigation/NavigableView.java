package com.hdekker.mobileapp.navigation;

import com.vaadin.flow.component.Component;

/**
 * To allow a view to be picked up by
 * a navigation menu, the view must implement this
 * interface.
 * 
 * @author HDekker
 *
 */
public class NavigableView {

	Class<? extends Component> clazzForNavigation;
	String viewLinkText;
	
	public NavigableView(Class<? extends Component> class1, String string) {
		clazzForNavigation = class1;
		viewLinkText = string;
	}

	public Class<? extends Component> getClazzForNavigation() {
		return clazzForNavigation;
	}

	public void setClazzForNavigation(Class<? extends Component> clazzForNavigation) {
		this.clazzForNavigation = clazzForNavigation;
	}

	public String getViewLinkText() {
		return viewLinkText;
	}

	public void setViewLinkText(String viewLinkText) {
		this.viewLinkText = viewLinkText;
	}
	
}
