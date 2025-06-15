package hello.aop.aop.member;

import hello.aop.aop.member.annotation.MethodAop;

public class MemberServiceImpl implements MemberService{
    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "Ok";
    }

    public String internal (String param){
        return "ok";
    }
}
