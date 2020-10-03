package com.hdekker.mobileapp.layout;

import com.hdekker.mobileapp.components.RowItem;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;


@Tag("side-bar-menu-layout")
@JsModule("./side-bar-menu-layout.js")
public class SideBarMenuLayout extends PolymerTemplate<TemplateModel>{
	
	@Id("main-layout")
	VerticalLayout main;
	
	@Id("side-bar-closer")
	Button closer; // new Button(new Icon(VaadinIcon.CLOSE_BIG));
	
	@Id("side-bar-opener")
	Button opener; // = new Button(new Icon(VaadinIcon.MENU));
	
	@Id("content")
	VerticalLayout innerContent; 
	
	@Id("application-name")
	Div div;
	
	public SideBarMenuLayout(String applicationName) {
	
		closer.setIcon(new Icon(VaadinIcon.CLOSE_BIG));
		opener.setIcon(new Icon(VaadinIcon.MENU));
		
		setId("side-bar-menu");
		main.setWidth(null);
		main.setPadding(false);
		main.setSpacing(false);
		
		H3 appName = new H3(applicationName);
		appName.getElement().setAttribute("slot", "appName");
		getElement().appendChild(appName.getElement());
		
	}
	
	public void addNavigationItem(Button button) {
		
		innerContent.add(new RowItem(button));
	}

	public void setCloser(Button button) {
	
		
		
	}
	
	public void openMenu() {
		
	}
	
	public void closeMenu() {
		getElement().callJsFunction("_close", "");
	}
	
}
