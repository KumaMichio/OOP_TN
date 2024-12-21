package hust.soict.hedspi.swing;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class ButtonListener implements ActionListener {
	private NumberGrid numberGrid;
	
    public ButtonListener(NumberGrid numberGrid) {
        this.numberGrid = numberGrid;
    }
    
	@Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
			numberGrid.getTfDisplay().setText(numberGrid.getTfDisplay().getText() + button);
        } else if (button.equals("DEL")) {
            String text = numberGrid.getTfDisplay().getText();
            if(!text.isEmpty()) {
            	numberGrid.getTfDisplay().setText(text.substring(0, text.length() - 1));
            }
        } else if(button.equals("C")) {
            numberGrid.getTfDisplay().setText("");
        }
    }
}
