/*
 * The MIT License
 *
 * Copyright 2016 oncore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.oncore.chhs.client.ejb;

import com.oncore.chhs.client.dto.AllMessages;

/**
 *
 * @author oncore
 */
public interface MessagesService {

    /**
     * The <code>sendMessage</code> method sends a message.
     *
     * @param from message from
     * @param to message to
     * @param messageTxt a message to send
     * @param userUid the userUid
     */
    public void sendMessage(String from, String to, String messageTxt, Integer userUid);

    /**
     * The <code>fetchMessages</code> method fetches all messages from the inbox
     * and outbox for the user.
     *
     * @param userUid the entity representing the user
     *
     * @return a map containing list of populated inbox and outbox
     * <code>MessageDTO</code> objects if found, empty list otherwise
     */
    public AllMessages getAllMessages(Integer userUid);
}
