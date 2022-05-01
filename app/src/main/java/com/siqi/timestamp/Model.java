package com.siqi.timestamp;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static class EntrySource{
        List<Entry> data = new ArrayList<>();
        public EntrySource(){}
        public EntrySource(List<Entry> data){
            this.data = data;
        }

        public Entry get(int i) {
            return this.data.get(i);
        }
    }
    public static class Entry{
    }
}
