package com.hdekker.mobileapp.navigation;

import java.util.function.Supplier;

public interface MenubarNavigable {
	Supplier<NavigableView> getNavigableView();
}
