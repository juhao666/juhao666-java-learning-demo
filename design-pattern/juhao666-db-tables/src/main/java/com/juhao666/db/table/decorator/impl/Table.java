package com.juhao666.db.table.decorator.impl;

import com.juhao666.db.table.ITable;

public abstract class Table implements ITable {

    public boolean hasChild = false;
    private ITable child;

    public void child(ITable child) {
        this.child = child;
        this.hasChild = true;
    }

    public void create() {
        this.child.create();
    }
}
