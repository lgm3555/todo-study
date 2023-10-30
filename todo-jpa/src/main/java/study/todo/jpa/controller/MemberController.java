package study.todo.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.todo.jpa.dto.MemberDto;
import study.todo.jpa.entity.Member;
import study.todo.jpa.repository.MemberRepository;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/v1/member/{id}")
    public String findMemberV1(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    /**
     * 도메인 클래스 컨버터 조회용으로만 사용
     */
    @GetMapping("/v2/member/{id}")
    public String findMemberV2(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    @GetMapping("/v1/members")
    public Page<Member> listV1(Pageable pageable) {
        Page<Member> result = memberRepository.findAll(pageable);
        return result;
    }

    @GetMapping("/v2/members")
    public Page<MemberDto> listV2(@PageableDefault(size = 5) Pageable pageable) {
        Page<MemberDto> result = memberRepository.findAll(pageable).map(MemberDto::new);
        return result;
    }

    @GetMapping("/v3/members")
    public Page<MemberDto> listV3(int page, int size, String sort) {
        PageRequest request = PageRequest.of(page, size, Sort.by(sort));
        Page<MemberDto> result = memberRepository.findAll(request).map(MemberDto::new);
        return result;
    }

    @PostConstruct
    public void init() {
        for (int i=0; i<100; i++) {
            memberRepository.save(new Member("user" + i, i));
        }
    }
}
