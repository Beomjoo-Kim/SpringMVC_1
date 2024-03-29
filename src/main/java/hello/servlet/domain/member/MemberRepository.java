package hello.servlet.domain.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음. 실무에서는 ConcurrentHashMap, AtomicLong 사용을 고려해야 한다.
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //singleton 으로 작성
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    //기본 생성자를 private 로 작성하여 임의로 instance 를 생성하는 것을 차단한다.
    private MemberRepository (){
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        //store 내부의 값에 접근하지 않기 위해 store 내부의 값을 모두 꺼내 새로운 arrayList 에 담아서 return.
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
