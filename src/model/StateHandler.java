package model;

import gui.BuyPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StateHandler {

    public enum State {ITEM_INPUT, USER_INPUT};
    
    static State state = State.ITEM_INPUT;
	
    BuyPanel buyPanel;
    
    public StateHandler(){
    	
    }
    
    public void addBuyPanel(BuyPanel ls){
    	buyPanel = ls;
    }
    
    
	public boolean isInStateItemInput() {
		return state.equals(State.ITEM_INPUT);
	}

	public void nextState() {
		if(state.equals(State.ITEM_INPUT)){
			state = State.USER_INPUT;
                    
                        
                }
		else if(state.equals(State.USER_INPUT)){
			state = State.ITEM_INPUT;
                }
	}
	
	private void stateWasUpdated(){
		
	}

	public boolean isInStateUserInput() {
		return state.equals(State.USER_INPUT);
	}

}
