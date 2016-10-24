package de.rincewind.api.gui.elements.abstracts;

import de.rincewind.api.gui.elements.util.Icon;

/**
 * With this element you can change the display of the element. If the element
 * is disabled, the {@link ElementDisplayable#getDisabledIcon()} will be displayed.
 * 
 * @author Rincewind34
 * @since 2.3.3
 * 
 * @see ElementSizeable
 */
public abstract interface ElementDisplayable extends Element {
	
	/**
	 * Returns the icon of this element.
	 * 
	 * @return the icon of this element
	 */
	public abstract Icon getIcon();
	
	/**
	 * Returns the icon displayed when the element is
	 * disabled.
	 * 
	 * @return the icon displayed when the element is
	 * 			disabled
	 */
	public abstract Icon getDisabledIcon();
	
	/**
	 * Sets an icon to this element.
	 * 
	 * @param icon to set
	 * 
	 * @throws NullPointerException if the icon is <code>null</code>
	 */
	public abstract void setIcon(Icon icon);
	
	/**
	 * Sets an icon to this element, visible when this element is
	 * disabled.
	 * 
	 * @param icon to set
	 * 
	 * @throws NullPointerException if the icon is <code>null</code>
	 */
	public abstract void setDisabledIcon(Icon icon);
	
}
