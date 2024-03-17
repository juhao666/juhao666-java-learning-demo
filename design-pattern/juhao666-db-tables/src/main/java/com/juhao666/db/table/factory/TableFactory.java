package com.juhao666.db.table.factory;

import com.juhao666.db.table.ITable;

public class TableFactory {
    public static SimpleAbstractTable table(String name) {
        SimpleAbstractTable table = new SimpleTable(name);
        table.create();
        return table;
    }
}
