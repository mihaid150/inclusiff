package org.project.services;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.project.dtos.ResponseMessage;
import org.project.dtos.TrainingDto;
import org.project.dtos.TrainingRegisterRequest;
import org.project.entities.TrainingRegistrationEntity;
import org.project.repositories.TrainingRegistrationRepository;
import org.project.repositories.TrainingRepository;
import org.project.services.mappers.TrainingMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HelpService {
    private final TrainingRepository trainingRepository;
    private final TrainingRegistrationRepository trainingRegistrationRepository;
    private final TrainingMapper trainingMapper = Mappers.getMapper(TrainingMapper.class);

    public ResponseMessage registerToTraining(TrainingRegisterRequest request) {
        trainingRegistrationRepository.save(TrainingRegistrationEntity.builder()
                .trainingExternalId(request.getTrainingExternalId())
                .userExternalId(request.getUserExternalId())
                .build());

        return ResponseMessage.builder()
                .message("Registered successfully!")
                .build();
    }

    public List<TrainingDto> getAllTrainings() {
        return trainingRepository.findAll().stream().map(trainingMapper::toDto).toList();
    }

    public List<UUID> getTrainingParticipants(UUID trainingExternalId) {
        return trainingRegistrationRepository.findAllByTrainingExternalId(trainingExternalId).stream()
                .map(TrainingRegistrationEntity::getUserExternalId).toList();
    }
}
