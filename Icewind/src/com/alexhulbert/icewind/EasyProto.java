/*
 * Copyright (C) 2014 Alex
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alexhulbert.icewind;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class EasyProto<T extends GeneratedMessage> {
    private final byte[] inp;
    private final Parser p;
    public EasyProto(Parser<T> parser, byte[] input) {
        inp = input;
        p = parser;
    }
    
    public T parse() throws InvalidProtocolBufferException {
        return (T) p.parseFrom(inp);
    }
    
    public T[] parseVarint() {
        ByteArrayInputStream bais = new ByteArrayInputStream(inp);
        List<T> lst = new ArrayList<T>();
        while(bais.available() > 0) {
            try {
                lst.add((T) p.parseDelimitedFrom(bais));
            } catch (InvalidProtocolBufferException ex) {}
        }
        return (T[]) lst.toArray();
    }
    
    public long size() {
        long s = 0;
        ByteArrayInputStream bais = new ByteArrayInputStream(inp);
        while (bais.available() > 0) {
            try {
                p.parseDelimitedFrom(bais);
                s++;
            } catch (InvalidProtocolBufferException ex) {}
        }
        return s;
    }
}
