package com.hdekker.mobileapp.navigation.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class BackButton extends Button {

	public BackButton() {
		setIcon(new Icon(VaadinIcon.CHEVRON_LEFT));
	}
}
