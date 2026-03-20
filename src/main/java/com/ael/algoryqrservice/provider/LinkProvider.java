package com.ael.algoryqrservice.provider;

import com.ael.algoryqrservice.model.Type;
import com.ael.algoryqrservice.model.dto.QrRequest;
import com.ael.algoryqrservice.model.dto.QrResponse;
import com.ael.algoryqrservice.repository.QrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkProvider implements QrProvider<QrRequest> {
    private final QrRepository qrRepository;

    @Override
    public Type getType() {
        return Type.LINK;
    }

    @Override
    public Class<QrRequest> requestType() {
        return QrRequest.class;
    }

    @Override
    public QrResponse createQr(QrRequest request) {
        return null;
    }
}
