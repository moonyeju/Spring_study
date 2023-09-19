package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy=new RateDiscountPolicy();
    //이렇게 하면 실제 구현 코드를 바꿔야함. 결론적으로 추상도 의존하고 구체적인 것도 의존하고 있음. DIP어김.
// FixDiscountPolicy 를 RateDiscountPolicy 로 변경하는 순간 OrderServiceImpl 의 소스코드도 함께 변경해야 한다! OCP 위반
    private DiscountPolicy discountPolicy;
    private MemberRepository memberRepository;
    //생성자 주입

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    //인터페이스에만 의존하도록 변경함.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId); //회원 정보 조회
        int discountPrice = discountPolicy.discount(member,itemPrice); //할인 조회 개인에 따라 등급만 던질지 전체를 던질지.
        //설계 잘한거. order서비스에서는 할인에 대해서 모름.
        //discountPolicy가 알아서 해줘 그러고 결과만 나한테 던져줘
        //단일 체계원칙 잘 지킴.
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
