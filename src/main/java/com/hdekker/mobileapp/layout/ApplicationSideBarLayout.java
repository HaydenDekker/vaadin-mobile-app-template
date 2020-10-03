package com.hdekker.mobileapp.layout;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;

import com.hdekker.mobileapp.config.AppLayoutConfig;
import com.hdekker.mobileapp.navigation.MenubarNavigable;
import com.hdekker.mobileapp.navigation.NavigableView;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.RouterLayout;

@StyleSheet("./shared-styles.css")
public class ApplicationSideBarLayout extends VerticalLayout implements RouterLayout{

	SideBarMenuLayout sideBarMenu;
	
	@Autowired
	List<MenubarNavigable> views;
	
	H3 viewHeader = new H3("");
	
	@Autowired
	AppLayoutConfig appLayoutConfig; 
	
	public ApplicationSideBarLayout(List<MenubarNavigable> views, 
									AppLayoutConfig appLayoutConfig) {
			
		this.views = views;
		
		sideBarMenu = new SideBarMenuLayout(appLayoutConfig.getApplicationName());
		add(sideBarMenu);
		setClassName("app-layout");
		
		setPadding(false);
		setMargin(false);
		
		VerticalLayout headerHolder = new VerticalLayout();
		headerHolder.setId("app-layout-header");
		headerHolder.addClassName("app-header");
		HorizontalLayout header = new HorizontalLayout();
		header.setClassName("flex-center");
		header.setWidthFull();
		header.setAlignItems(Alignment.BASELINE);
		headerHolder.add(header);
		add(headerHolder);
		
		// viewHeader.setText(appLayoutConfig.getApplicationName());
		
		HorizontalLayout spacer = new HorizontalLayout();
		spacer.setClassName("spacer");
	
		header.add(viewHeader);
		
		sideBarMenu.closeMenu();

		views.forEach(view->{
			Button b = new Button(view.getNavigableView().get().getViewLinkText());
			b.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
			sideBarMenu.addNavigationItem(b);
			b.addClickListener((e)->{
				UI.getCurrent().navigate(view.getNavigableView().get().getClazzForNavigation());
				sideBarMenu.closeMenu();
			});
			
		});

	}
	
	@Override
	public void showRouterLayoutContent(HasElement content) {
        if (content != null) {
        	
        	if(HasApplicationViewHeading.class.isAssignableFrom(content.getClass())) {
        		
        		viewHeader.setText(((HasApplicationViewHeading)content).getApplicationHeading());
        		
        	}
        	
            getElement()
                    .appendChild(Objects.requireNonNull(content.getElement()));
        }
    }
	
	@Override
	public Element getElement() {
	
		return super.getElement();
		
	}
}
