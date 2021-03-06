package de.rincewind.interfaceapi.gui.windows.util;

import de.rincewind.interfaceapi.gui.windows.abstracts.Window;
import de.rincewind.interfaceapi.setup.Setup;

/**
 * This enum is used by {@link Window} to save the current window-state
 * 
 * @author Rincewind34
 * @since 2.3.3
 * 
 * @see Setup
 */
public enum WindowState {
	
	/**
	 * If the window is in this state, to the owing player ({@link Window#getUser()}
	 * is the window-instance displayed.
	 */
	MAXIMIZED,
	
	/**
	 * @see Setup#minimize()
	 */
	BACKGROUND,
	
	/**
	 * If the window is in this state, the window is only opened and
	 * you can close maximize it
	 * 
	 * @see Setup#close(Window)
	 * @see Setup#maximize(Window)
	 */
	MINIMIZED,
	
	CLOSED;
	
}
