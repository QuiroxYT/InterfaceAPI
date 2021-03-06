package de.rincewind.interfaceapi.handling.element;

import de.rincewind.interfaceapi.gui.components.Displayable;
import de.rincewind.interfaceapi.gui.elements.ElementMap;
import de.rincewind.interfaceapi.gui.elements.util.Point;

public class MapChangeSelectEvent extends ElementEvent<ElementMap> {

	private int newIndex;

	public MapChangeSelectEvent(ElementMap element, int newIndex) {
		super(element);

		this.newIndex = newIndex;
	}
	
	public boolean wasUnselect() {
		return this.newIndex == -1;
	}
	
	public int getNewIndex() {
		return this.newIndex;
	}

	public Point getClickedPoint() {
		return this.getElement().getPoint(this.newIndex);
	}

	public <T extends Displayable> T getClicked() {
		return this.getElement().getItem(this.getClickedPoint());
	}
	
	public <T extends Displayable> T getClicked(Class<T> cls) {
		return this.getElement().getItem(cls, this.getClickedPoint());
	}

}
