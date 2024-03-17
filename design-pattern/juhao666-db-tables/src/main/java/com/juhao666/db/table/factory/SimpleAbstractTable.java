package com.juhao666.db.table.factory;

import com.juhao666.db.table.ITable;

public abstract class SimpleAbstractTable implements ITable {
    private SimpleAbstractTable child;

    public SimpleAbstractTable child(String name) {
        this.child = new SimpleTable(name);
        this.child.create();
        return this.child;
    }
}
