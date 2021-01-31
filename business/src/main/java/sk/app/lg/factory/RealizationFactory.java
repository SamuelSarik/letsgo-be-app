package sk.app.lg.factory;

import sk.app.lg.Realization;
import sk.app.lg.dto.RealizationRequest;

public final class RealizationFactory {

    public static Realization createRealization(RealizationRequest request) {
        return Realization.builder()
                .id(request.getId())
                .userId(request.getUserId())
                .eventId(request.getEventId())
                .notifiedAt(request.getNotifiedAt())
                .build();
    }
}
