package com.scores365.entitys;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.m;
/* compiled from: AtsRecords.kt */
/* loaded from: classes2.dex */
public final class AtsRecords implements Serializable {
    @p9.c("Columns")
    private final List<BaseObj> columns;
    @p9.c("Rows")
    private final List<Row> rows;
    @p9.c("Title")
    private final String title;

    /* compiled from: AtsRecords.kt */
    /* loaded from: classes2.dex */
    public static final class Column implements Serializable {
        @p9.c("Id")

        /* renamed from: id  reason: collision with root package name */
        private final int f23581id;
        @p9.c("Name")
        private final String name;

        public Column(int i10, String name) {
            m.g(name, "name");
            this.f23581id = i10;
            this.name = name;
        }

        public static /* synthetic */ Column copy$default(Column column, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = column.f23581id;
            }
            if ((i11 & 2) != 0) {
                str = column.name;
            }
            return column.copy(i10, str);
        }

        public final int component1() {
            return this.f23581id;
        }

        public final String component2() {
            return this.name;
        }

        public final Column copy(int i10, String name) {
            m.g(name, "name");
            return new Column(i10, name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Column) {
                Column column = (Column) obj;
                return this.f23581id == column.f23581id && m.b(this.name, column.name);
            }
            return false;
        }

        public final int getId() {
            return this.f23581id;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.f23581id * 31) + this.name.hashCode();
        }

        public String toString() {
            return "Column(id=" + this.f23581id + ", name=" + this.name + ')';
        }
    }

    /* compiled from: AtsRecords.kt */
    /* loaded from: classes2.dex */
    public static final class Row implements Serializable {
        @p9.c("CompetitorNum")
        private final int competitorNum;
        @p9.c("Values")
        private final List<Value> values;

        /* compiled from: AtsRecords.kt */
        /* loaded from: classes2.dex */
        public static final class Value implements Serializable {
            @p9.c("ColumnNumber")
            private final int columnNumber;
            @p9.c("Value")
            private final String value;

            public Value(int i10, String value) {
                m.g(value, "value");
                this.columnNumber = i10;
                this.value = value;
            }

            public static /* synthetic */ Value copy$default(Value value, int i10, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    i10 = value.columnNumber;
                }
                if ((i11 & 2) != 0) {
                    str = value.value;
                }
                return value.copy(i10, str);
            }

            public final int component1() {
                return this.columnNumber;
            }

            public final String component2() {
                return this.value;
            }

            public final Value copy(int i10, String value) {
                m.g(value, "value");
                return new Value(i10, value);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Value) {
                    Value value = (Value) obj;
                    return this.columnNumber == value.columnNumber && m.b(this.value, value.value);
                }
                return false;
            }

            public final int getColumnNumber() {
                return this.columnNumber;
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return (this.columnNumber * 31) + this.value.hashCode();
            }

            public String toString() {
                return "Value(columnNumber=" + this.columnNumber + ", value=" + this.value + ')';
            }
        }

        public Row(int i10, List<Value> values) {
            m.g(values, "values");
            this.competitorNum = i10;
            this.values = values;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Row copy$default(Row row, int i10, List list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = row.competitorNum;
            }
            if ((i11 & 2) != 0) {
                list = row.values;
            }
            return row.copy(i10, list);
        }

        public final int component1() {
            return this.competitorNum;
        }

        public final List<Value> component2() {
            return this.values;
        }

        public final Row copy(int i10, List<Value> values) {
            m.g(values, "values");
            return new Row(i10, values);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Row) {
                Row row = (Row) obj;
                return this.competitorNum == row.competitorNum && m.b(this.values, row.values);
            }
            return false;
        }

        public final int getCompetitorNum() {
            return this.competitorNum;
        }

        public final List<Value> getValues() {
            return this.values;
        }

        public int hashCode() {
            return (this.competitorNum * 31) + this.values.hashCode();
        }

        public String toString() {
            return "Row(competitorNum=" + this.competitorNum + ", values=" + this.values + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AtsRecords(List<? extends BaseObj> columns, List<Row> rows, String title) {
        m.g(columns, "columns");
        m.g(rows, "rows");
        m.g(title, "title");
        this.columns = columns;
        this.rows = rows;
        this.title = title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AtsRecords copy$default(AtsRecords atsRecords, List list, List list2, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = atsRecords.columns;
        }
        if ((i10 & 2) != 0) {
            list2 = atsRecords.rows;
        }
        if ((i10 & 4) != 0) {
            str = atsRecords.title;
        }
        return atsRecords.copy(list, list2, str);
    }

    public final List<BaseObj> component1() {
        return this.columns;
    }

    public final List<Row> component2() {
        return this.rows;
    }

    public final String component3() {
        return this.title;
    }

    public final AtsRecords copy(List<? extends BaseObj> columns, List<Row> rows, String title) {
        m.g(columns, "columns");
        m.g(rows, "rows");
        m.g(title, "title");
        return new AtsRecords(columns, rows, title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AtsRecords) {
            AtsRecords atsRecords = (AtsRecords) obj;
            return m.b(this.columns, atsRecords.columns) && m.b(this.rows, atsRecords.rows) && m.b(this.title, atsRecords.title);
        }
        return false;
    }

    public final List<BaseObj> getColumns() {
        return this.columns;
    }

    public final List<Row> getRows() {
        return this.rows;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.columns.hashCode() * 31) + this.rows.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "AtsRecords(columns=" + this.columns + ", rows=" + this.rows + ", title=" + this.title + ')';
    }
}
