package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member kim = new Member("kim", 20);

        Member savedMember = memberRepository.save(kim);

        Member foundMember = memberRepository.findById(savedMember.getId());
        assertThat(foundMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        Member kim = new Member("kim", 20);
        Member lee = new Member("Lee", 30);

        Member savedKim = memberRepository.save(kim);
        Member savedLee = memberRepository.save(lee);

        List<Member> savedMembers = memberRepository.findAll();

        assertThat(savedMembers)
                .contains(savedKim)
                .contains(savedLee)
                .containsExactlyInAnyOrder(savedLee, savedKim);
    }
}