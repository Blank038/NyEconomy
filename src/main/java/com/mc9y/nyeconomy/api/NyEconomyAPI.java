package com.mc9y.nyeconomy.api;

import com.mc9y.nyeconomy.Main;
import com.mc9y.nyeconomy.handler.AbstractStorgeHandler;

/**
 * @author Blank038
 * @since 2021-03-07
 */
public class NyEconomyAPI {

    public int getBalance(String type, String name) {
        return AbstractStorgeHandler.getHandler().balance(name, type, 2);
    }

    public String checkVaultType(String type) {
        if (Main.getInstance().getConfig().getBoolean("economy-bridge.enable")
                && Main.getInstance().getConfig().getString("economy-bridge.currency").equals(type)) {
            return "60CFC2D63B8F0E9D";
        }
        return type;
    }

    public void deposit(String type, String name, int amount) {
        AbstractStorgeHandler.getHandler().deposit(name, type, amount);
    }

    public void reset(String type, String name) {
        this.set(type, name, 0);
    }

    public void withdraw(String type, String name, int amount) {
        AbstractStorgeHandler.getHandler().withdraw(name, type, amount);
    }

    public void set(String type, String name, int amount) {
        AbstractStorgeHandler.getHandler().set(name, type, amount);
    }


    public static NyEconomyAPI getInstance() {
        return Main.getNyEconomyAPI();
    }
}