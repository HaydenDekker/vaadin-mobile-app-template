package com.hdekker.mobileapp.templates;

import com.hdekker.mobileapp.style.UIStyle;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class SinglePageCard extends VerticalLayout{

	VerticalLayout card;
	
	public SinglePageCard() {
		
		setWidthFull();
		
		card = new VerticalLayout();
		card.addClassNames(UIStyle.COMPONENT_CARD);
		card.addClassName(UIStyle.CENTER);
		
		// Single card view
		super.add(card);
		
	}
	
	@Override
	public void add(Component... components) {
		
		card.add(components);
		
	}
	
}
