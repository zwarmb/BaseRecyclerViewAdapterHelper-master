package com.example.yida.qq.impl.provider;

import com.example.yida.qq.api.model.SimpleCallback;
import com.example.yida.qq.api.model.chatroom.ChatRoomProvider;
import com.example.yida.qq.impl.cache.ChatRoomMemberCache;
import com.netease.nimlib.sdk.chatroom.constant.MemberQueryType;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMember;

import java.util.List;

/**
 * Created by hzchenkang on 2017/11/2.
 */

public class DefaultChatRoomProvider implements ChatRoomProvider {

    @Override
    public ChatRoomMember getChatRoomMember(String roomId, String account) {
        return ChatRoomMemberCache.getInstance().getChatRoomMember(roomId, account);
    }

    @Override
    public void fetchMember(String roomId, String account, SimpleCallback<ChatRoomMember> callback) {
        ChatRoomMemberCache.getInstance().fetchMember(roomId, account, callback);
    }

    @Override
    public void fetchRoomMembers(String roomId, MemberQueryType memberQueryType, long time, int limit, SimpleCallback<List<ChatRoomMember>> callback) {
        ChatRoomMemberCache.getInstance().fetchRoomMembers(roomId, memberQueryType, time, limit, callback);
    }
}
