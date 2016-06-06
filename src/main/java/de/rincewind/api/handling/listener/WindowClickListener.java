package de.rincewind.api.handling.listener;

import de.rincewind.api.handling.events.WindowClickEvent;

public abstract class WindowClickListener implements WindowListener<WindowClickEvent> {

	@Override
	public Class<WindowClickEvent> getEventClass() {
		return WindowClickEvent.class;
	}

}