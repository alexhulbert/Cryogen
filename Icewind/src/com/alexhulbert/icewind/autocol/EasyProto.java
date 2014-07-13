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

package com.alexhulbert.icewind.autocol;

import com.alexhulbert.icewind.LoadingBar;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class EasyProto<T extends GeneratedMessage> {
    private final byte[] inp;
    private final Parser p;
    
    protected EasyProto(Parser<T> parser, byte[] input) {
        inp = input;
        p   = parser;
    }
    
    /**
     * Decode a single, protobuf-encoded Message
     * @return a decoded instance of type T
     * @throws InvalidProtocolBufferException Doesn't fit the protobuf
     */
    public T parse() throws InvalidProtocolBufferException {
        return (T) p.parseFrom(inp);
    }
    
    /**
     * Parse and decode a varint-delimited, protobuf-encoded Message array
     * @return An array of T messages
     */
    public List<T> parseVarint() {
        ByteArrayInputStream bais = new ByteArrayInputStream(inp);
        List<T> lst = new ArrayList<T>();
        while (bais.available() > 0) {
            try {
                lst.add((T) p.parseDelimitedFrom(bais));
            } catch (InvalidProtocolBufferException ex) {
                //TODO: Fix this
                ex.printStackTrace();
            }
        }
        
        return lst;
    }
    
    /**
     * How many varint-encoded messages are contained within the input
     * @return The number of messages
     */
    public long size() {
        long s = 0;
        ByteArrayInputStream bais = new ByteArrayInputStream(inp);
        while (bais.available() > 0) {
            try {
                p.parseDelimitedFrom(bais);
                s++;
            } catch (InvalidProtocolBufferException ex) {
                ex.printStackTrace(); //TODO: Fix this
            }
        }
        return s;
    }
    
    /**
     * This is a little slower, but you can use it with those pretty progress bars. No more boring throbbers!
     * @param lb The LoadingBar instance to write to
     * @param loadText The prefixed
     * @return An array of T messages
     */
    public List<T> parseVarint(LoadingBar lb, String loadText) {
        ByteArrayInputStream counter = new ByteArrayInputStream(inp);
        ByteArrayInputStream parser  = new ByteArrayInputStream(inp); //Pass-by-reference
        long totalCount = 0;
        List<T> output = new ArrayList<T>();
        while (counter.available() > 0) {
            try {
                p.parseDelimitedFrom(counter);
                totalCount++;
            } catch (InvalidProtocolBufferException ex) {}
        }
        
        for (int i = 0; i < totalCount; i++) {
            try {
                output.add((T) p.parseDelimitedFrom(parser));
                lb.progress((i*100)/totalCount);
                lb.status(loadText + String.format(" (%s/%s)", i, totalCount));
            } catch (InvalidProtocolBufferException ex) {
                ex.printStackTrace(); //TODO: Fix this
            }
        }
        return output;
    }
}
