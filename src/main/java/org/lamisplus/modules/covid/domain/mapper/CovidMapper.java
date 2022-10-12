package org.lamisplus.modules.covid.domain.mapper;

import org.lamisplus.modules.covid.domain.dto.*;
import org.lamisplus.modules.covid.domain.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CovidMapper {
    CodeSet toCodeSet(CodeSetDTO codeSetDTO);
    Encounter toEncounter(EncounterDTO encounterDTO);
    Patient toPatient(PatientDTO patientDTO);
    Question toQuestion(QuestionDTO questionDTO);
    QuestionAnswer toQuestionAnswer(QuestionAnswerDTO questionAnswerDTO);
    QuestionResponse toQuestionResponse(QuestionResponseDTO questionResponseDTO);
    Vaccination toVaccination(VaccinationDTO vaccinationDTO);
    VaccinationDose toVaccinationDose(VaccinationDoseDTO vaccinationDoseDTO);

    CodeSetDTO toCodeSetDto(CodeSet codeSet);
    EncounterDTO toEncounterDto(Encounter encounter);
    PatientDTO toPatientDto(Patient patient);
    QuestionDTO toQuestionDto(Question question);
    QuestionAnswerDTO toQuestionAnswerDto(QuestionAnswer questionAnswer);
    QuestionResponseDTO toQuestionResponseDto(QuestionResponse questionResponse);
    VaccinationDTO toVaccinationDto(Vaccination vaccination);
    VaccinationDoseDTO toVaccinationDoseDto(VaccinationDose vaccinationDose);


    List<CodeSetDTO> toCodeSetDtoList(List<CodeSet> codeSets);
    List<EncounterDTO> toEncounterDtoList(List<Encounter> encounters);
    List<PatientDTO> toPatientDtoList(List<Patient> patients);
    List<QuestionDTO> toQuestionDtoList(List<Question> questions);
    List<QuestionAnswerDTO> toQuestionAnswerDtoList(List<QuestionAnswer> questionAnswers);
    List<QuestionResponseDTO> toQuestionResponseDtoList(List<QuestionResponse> questionResponses);
    List<VaccinationDTO> toVaccinationDtoList(List<Vaccination> vaccinationList);
    List<VaccinationDoseDTO> toVaccinationDoseDtoList(List<VaccinationDose> vaccinationDoseList);
}
