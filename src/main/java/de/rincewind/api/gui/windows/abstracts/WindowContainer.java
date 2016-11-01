package de.rincewind.api.gui.windows.abstracts;

import java.util.function.Consumer;

import de.rincewind.api.gui.elements.util.Point;

/**
 * This window is InventoryGUI. If you change the name or 
 * something like this, the inventory will be automatically
 * recreated and if this window already has a user, the inventory
 * will be opened completely new.
 * 
 * @author Rincewind34
 * @since 2.3.3
 * 
 * @see WindowEditor
 */
public abstract interface WindowContainer extends WindowNameable {
	
	public abstract void iterate(Consumer<Point> action);
	
}
