/*
 * Respnsible for updateing the BuyPanel and the buy
 */
package model;

import gui.BuyPanel;

/**
 *
 * @author Emil
 */
public class BuyHandler {
    
    BuyPanel bp;
    
    Item item;
    User user;
    
    ExcelBridge eb;
    
    public BuyHandler (ExcelBridge eb){
        this.eb = eb;
    }
   
    public void setBuyPanel(BuyPanel bp){
        this.bp = bp;
    }
    
    public void setItem(Item item){
    	this.item = item;
        bp.setItem(item.name, "" + item.price);
    }
    
    public void setUser(User user){
    	this.user = user;
        bp.setUser(user.name);
    }
    
    /**
     * Not implemented yet
     * @return 
     */
    public boolean doBuy(){
    	return eb.updateDept(user.dept + item.price, user);
    }
    
    
}
