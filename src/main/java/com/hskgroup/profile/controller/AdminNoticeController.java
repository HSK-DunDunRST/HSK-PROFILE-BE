package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.apiPayload.status.SuccessStatus;
import com.hskgroup.profile.dto.req.NoticeCreateReq;
import com.hskgroup.profile.dto.res.NoticeRes;
import com.hskgroup.profile.dto.req.NoticeUpdateReq;
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
@RequestMapping("/adm/notice")
@RequiredArgsConstructor
public class AdminNoticeController {

    private final NoticeService noticeService;

    @PostMapping("/add")
    public ApiResponse<NoticeRes> createNotice(@RequestBody NoticeCreateReq noticeCreateReq) {
        return ApiResponse.onSuccess(noticeService.createNotice(noticeCreateReq));
    }

    @PutMapping("/edit/{noticeId}")
    public ApiResponse<NoticeRes> updateNotice(@PathVariable UUID noticeId, @RequestBody NoticeUpdateReq noticeUpdateReq) {
        return noticeService.updateNotice(noticeId, noticeUpdateReq)
                .map(notice -> ApiResponse.of(SuccessStatus._OK, notice))
                .orElse(ApiResponse.of(SuccessStatus._OK, null));
    }

    @DeleteMapping("/del/{noticeId}")
    public ApiResponse<Void> deleteNotice(@PathVariable UUID noticeId) {
        boolean deleted = noticeService.deleteNotice(noticeId);
        return deleted ? ApiResponse.of(SuccessStatus._OK, null) : ApiResponse.of(SuccessStatus._NO_CONTENT, null);
    }
}
