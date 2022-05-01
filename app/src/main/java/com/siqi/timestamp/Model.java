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

        public int count(){
            return this.data.size();
        }
    }
    public static class Entry{
        public String content;
        public Entry(String content){
            this.content = content;
        }
    }
}
