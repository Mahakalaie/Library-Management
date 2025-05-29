package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    // TODO: Define a data structure that stores memberIds and their matching member objects
    private CustomHashMap<String, Member> memberIDs;

    public MemberManager() {
        // TODO: Initialize your data structure here
        memberIDs = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        // TODO: Add member and their id to your data structure
        memberIDs.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        // TODO
        return memberIDs.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        // TODO
        getMember(memberId).addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        // TODO
        return getMember(memberId).getLastTransaction();
    }
}
