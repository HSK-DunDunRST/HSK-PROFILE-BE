package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.apiPayload.status.SuccessStatus;
import com.hskgroup.profile.dto.NoticeCreateReq;
import com.hskgroup.profile.dto.NoticeRes;
import com.hskgroup.profile.dto.NoticeUpdateReq;
import com.hskgroup.profile.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/admin/notice")
@RequiredArgsConstructor
public class AdminNoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public ApiResponse<NoticeRes> createNotice(@RequestBody NoticeCreateReq request) {
        return ApiResponse.onSuccess(noticeService.createNotice(request));
    }

    @PutMapping("/{noticeUuid}")
    public ApiResponse<NoticeRes> updateNotice(@PathVariable UUID noticeUuid, @RequestBody NoticeUpdateReq request) {
        return noticeService.updateNotice(noticeUuid, request)
                .map(notice -> ApiResponse.of(SuccessStatus._OK, notice))
                .orElse(ApiResponse.of(SuccessStatus._NO_CONTENT, null));
    }

    @DeleteMapping("/{noticeUuid}")
    public ApiResponse<Void> deleteNotice(@PathVariable UUID noticeUuid) {
        boolean deleted = noticeService.deleteNotice(noticeUuid);
        return deleted
                ? ApiResponse.of(SuccessStatus._OK, null)
                : ApiResponse.of(SuccessStatus._NO_CONTENT, null);
    }
}
