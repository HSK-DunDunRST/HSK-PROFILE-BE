package com.hskgroup.profile.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeCreateReq {
    private String noticeTitle;
    private String noticeContent;
}
