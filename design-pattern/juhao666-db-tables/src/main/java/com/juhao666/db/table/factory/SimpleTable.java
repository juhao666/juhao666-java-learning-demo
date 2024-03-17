package com.juhao666.db.table.factory;

import com.juhao666.db.table.ITable;
import com.juhao666.db.table.decorator.impl.Table;

public class SimpleTable extends SimpleAbstractTable {
    String name;
    public SimpleTable(String name) {
        this.name = name;
    }

    public void create() {
        System.out.println(String.format("table %s created", name));
    }
}
