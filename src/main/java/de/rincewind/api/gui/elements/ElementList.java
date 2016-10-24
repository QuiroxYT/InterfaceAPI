package de.rincewind.api.gui.elements;

import java.util.List;
import java.util.function.Function;

import org.bukkit.inventory.ItemStack;

import de.rincewind.api.exceptions.APIException;
import de.rincewind.api.gui.components.Modifyable;
import de.rincewind.api.gui.components.Selectable;
import de.rincewind.api.gui.elements.ElementList.ListItem;
import de.rincewind.api.gui.elements.abstracts.ElementSizeable;
import de.rincewind.api.gui.elements.util.Elements.ElementListExtendable;
import de.rincewind.api.gui.elements.util.Icon;
import de.rincewind.api.gui.util.Color;
import de.rincewind.api.gui.util.Directionality;
import de.rincewind.api.handling.events.ListSelectEvent;
import de.rincewind.api.handling.events.ListUnselectEvent;

/**
 * With this element you can create a list of entries and you are able to scroll through
 * the entries.
 * 
 * The list can be resized, and perhaps the entries will be resized too. You can only scroll
 * in one direction through the list. This depends on the type of this list. If the type is
 * {@link Directionality#HORIZONTAL} the entries will be rendered laying from the right to the
 * left (Horizontal), so they will be added to the list from the top to the bottom. With
 * {@link Directionality#VERTICAL} the same but you scroll the right to the left.
 * 
 * This element contains its own color. This color will be displayed, when there are not enough
 * entries to fill the area of the list, or when you scroll to the end of the list.
 * 
 * If the user clicks on an entry, this entry will be selected (by the default, it will be enchanted).
 * By an second click on the selected entry, the entry will be unselected.
 * 
 * For a better handling with this element, you can 'save' an object from an specified
 * type in each list-entry. You can get this object from each entry. For example you can save
 * a {@link String} in an entry an your able to identify the entries by that string. Therefore,
 * you do not have to compare the icons or the entries its self.
 * 
 * This element implements {@link Iterable} to iterate throw all added entries.
 * 
 * This element implements {@link Selectable} and defines the method {@link Selectable#select()}
 * as <code>this.select(0)</code> with a little check if the size is not 0. If it is 0 the {@link APIException}
 * will be thrown.
 * 
 * The {@link ListSelectEvent} will be called, when the user selects an entry or you calls the method
 * {@link ElementList#select(int)}.
 * 
 * The {@link ListUnselectEvent} will be called, when the user unselects the selected entry or you calls the method
 * {@link Selectable#unselect()}.
 * 
 * @param <T> specifying the object-type
 * 
 * @author Rincewind34
 * @since 2.3.3
 * 
 * @see ElementListExtendable
 */
public abstract interface ElementList<T> extends ElementSizeable, Iterable<ListItem<T>>, Selectable {
	
	/**
	 * Returns all the added entries as an unmodifiable list.
	 * 
	 * @return all the added entries
	 */
	public abstract List<ListItem<T>> getItems();
	
	/**
	 * Returns the selected entry. If there is no selected entry, this method
	 * will return <code>null</code>.
	 * 
	 * @return the selected entry
	 */
	public abstract ListItem<T> getSelected();
	
	/**
	 * Modifies an item like the selected one and returns the modified item.
	 * 
	 * @param item to modify
	 * 
	 * @return the modified item.
	 * 
	 * @throws NullPointerException if the item is <code>null</code>
	 */
	public abstract ItemStack modifyToSelect(ItemStack item);
	
	/**
	 * Returns the color of this element. By the default, it is {@link Color#TRANSLUCENT}
	 * 
	 * @return the color of this element
	 */
	public abstract Color getColor();
	
	//TODO boolean canSelect(int index)
	
	/**
	 * Sets the color to a specified value. This method does not update the color
	 * by its self to the handler ({@link Modifyable}).
	 * 
	 * @param color The color to set
	 */
	public abstract void setColor(Color color);
	
	/**
	 * Adds an entry to this list. The list will be automaticly updated
	 * in the {@link Modifyable}.
	 * 
	 * @param item to add
	 * 
	 * @throws NullPointerException if the item is <code>null</code>
	 */
	public abstract void addItem(ListItem<T> item);
	
	/**
	 * Removes an entry from this list. The list will be automaticly updated
	 * in the {@link Modifyable}.
	 * 
	 * @param item to remove
	 * 
	 * @throws NullPointerException if the item is <code>null</code>
	 */
	public abstract void removeItem(ListItem<T> item);
	
	/**
	 * Changes the type of this list. By the default it is {@link Directionality#VERTICAL}.
	 * 
	 * @param type to set
	 * 
	 * @throws NullPointerException if the type is <code>null</code>
	 */
	public abstract void setType(Directionality type);
	
	/**
	 * Sets the index of the first displayed entry. If the index does not match the
	 * frame of 0 and the size of the entrylist subtracting 1, this method will do
	 * nothing.
	 * 
	 * @param index to set
	 */
	public abstract void setStartIndex(int index);
	
	/**
	 * Selects a specified index. If the index is not selectable, this method will
	 * do nothing.
	 * 
	 * @param index to select
	 */
	public abstract void select(int index);
	
	/**
	 * Sets the {@link ItemModifier} used to modify the entry, witch is selected.
	 * 
	 * @param modifier The modifier to set
	 * 
	 * @throws NullPointerException if the modifier is <code>null</code>
	 */
	public abstract void setSelectModifyer(Function<ItemStack, ItemStack> modifier);
	
	/**
	 * Adds to an {@link ElementButton} a listener to scroll through this element. The value to
	 * scroll forwards by clicking the button can be specified. If the user shiftclicks the button, the value
	 * will be multiplied by 2.
	 * 
	 * You can also set the value to a number smaller than 0 to scroll backwards through this element
	 * by clicking the button.
	 * 
	 * @param btn add the listener to
	 * @param value scrolling through this element by clicking
	 * 
	 * @throws NullPointerException if the button is <code>null</code>
	 */
	public abstract void addScroler(ElementButton btn, int value);
	
	/**
	 * Returns the index of the first displayed entry (at the beginning of this element).
	 * 
	 * @return the index of the first displayed entry
	 */
	public abstract int getStartIndex();
	
	/**
	 * Returns the currently selected index of this element. If there is no selected
	 * entry, this method returns -1.
	 * 
	 * @return the currently selected index of this element
	 */
	public abstract int getSelectedIndex();
	
	/**
	 * Returns the size of the entrylist.
	 * 
	 * @return the size of the entrylist
	 */
	public abstract int getSize();
	
	
	/**
	 * This is the class, you can add to the {@link ElementList}. You have to
	 * add an {@link ItemStack} / {@link Icon}, witch will be displayed, when this
	 * instance is selected, and a value with an specified type.
	 * 
	 * The value is only for you something to save in each entry.
	 * 
	 * @param <K> specifying value type. It is automaticly the same, you set in the root
	 * 				class {@link ElementList} as the parameter <code>T</code>.
	 * 
	 * @author Rincewind34
	 * @since 2.3.3
	 * 
	 * @see ElementList
	 */
	public static class ListItem<K> {
		
		private ItemStack item;
		private K save;
		
		public ListItem(ItemStack item, K save) {
			this.item = item;
			this.save = save;
		}
		
		public ListItem(Icon icon, K save) {
			this(icon.toItem(), save);
		}
		
		public ItemStack getItem() {
			return this.item;
		}
		
		public K getSave() {
			return this.save;
		}
		
	}
	
}
