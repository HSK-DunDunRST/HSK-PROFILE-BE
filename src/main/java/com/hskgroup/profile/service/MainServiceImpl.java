package com.hskgroup.profile.service;

import com.hskgroup.profile.dto.MainRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainServiceImpl implements MainService {

    @Override // 통합 조회
    public MainRes getMainData() {
        return null;
    }
}
