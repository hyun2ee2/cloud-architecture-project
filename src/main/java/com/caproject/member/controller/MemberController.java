package com.caproject.member.controller;

import com.caproject.member.dto.FileDownloadUrlResponse;
import com.caproject.member.dto.FileUploadResponse;
import com.caproject.member.dto.GetMemberResponse;
import com.caproject.member.entity.Member;
import com.caproject.member.service.MemberService;
import com.caproject.member.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 멤버 생성
    @PostMapping
    public Member createMember(
            @RequestBody
            Member member
    ) {
        log.info("[LOG] 회원 생성 요청");
        return memberService.save(member);
    }

    // 멤버 조회
    @GetMapping("/{id}")
    public GetMemberResponse getMember(@PathVariable Long id) {
        log.info("[LOG] 회원 조회 요청 ID : {}", id);
        return memberService.findById(id);
    }

    // 이미지 업로드
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/members")
    public class FileController {

        private final S3Service s3Service;

        @PostMapping("/{id}/profile-image")
        public ResponseEntity<FileUploadResponse> upload(@RequestParam("file") MultipartFile file) {
            String key = s3Service.upload(file);
            return ResponseEntity.ok(new FileUploadResponse(key));
        }

        @GetMapping("/{id}/profile-image")
        public ResponseEntity<FileDownloadUrlResponse> getDownloadUrl(@RequestParam String key) {
            URL url = s3Service.getDownloadUrl(key);
            return ResponseEntity.ok(new FileDownloadUrlResponse(url.toString()));
        }
    }
}
