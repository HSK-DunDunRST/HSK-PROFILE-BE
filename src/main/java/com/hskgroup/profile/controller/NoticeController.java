package com.hskgroup.profile.controller;

import com.hskgroup.profile.apiPayload.ApiResponse;
import com.hskgroup.profile.apiPayload.status.SuccessStatus;
import com.hskgroup.profile.dto.NoticeRes;
import com.hskgroup.profile.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/all")
    public ApiResponse<List<NoticeRes>> getAllNotice(){
        return ApiResponse.onSuccess(noticeService.getAllNotices());
    }

    @GetMapping("/last")
    public ApiResponse<NoticeRes> getLastNotice() {
        return noticeService.getRecentNotice()
                .map(notice -> ApiResponse.of(SuccessStatus._OK, notice))
                .orElse(ApiResponse.of(SuccessStatus._NO_CONTENT, null));
    }

    @GetMapping("/{noticeUuid}")
    public ApiResponse<NoticeRes> getNoticeByUuid(@PathVariable UUID noticeUuid) {
        return noticeService.getNoticeByUuid(noticeUuid)
                .map(notice -> ApiResponse.of(SuccessStatus._OK, notice))
                .orElse(ApiResponse.of(SuccessStatus._NO_CONTENT, null));
    }
}
