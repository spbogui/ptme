/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.ptme.api.impl;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Relationship;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.ptme.*;
import org.openmrs.module.ptme.api.PreventTransmissionService;
import org.openmrs.module.ptme.api.db.PreventTransmissionDAO;
import org.openmrs.module.ptme.utils.*;

import java.util.Date;
import java.util.List;

/**
 * It is a default implementation of {@link PreventTransmissionService}.
 */
public class PreventTransmissionServiceImpl extends BaseOpenmrsService implements PreventTransmissionService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private PreventTransmissionDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(PreventTransmissionDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public PreventTransmissionDAO getDao() {
	    return dao;
    }


    /**
     * Pregnant Patient
     */

    @Override
    public List<PregnantPatient> getAllPregnantPatient() {
        return dao.getAllPregnantPatient();
    }

    @Override
    public PregnantPatient getPregnantPatientById(Integer id) {
        return dao.getPregnantPatientById(id);
    }

    @Override
    public PregnantPatient savePregnantPatient(PregnantPatient pregnantPatient) {
        return dao.savePregnantPatient(pregnantPatient);
    }

    @Override
    public void deletePregnantPatient(PregnantPatient pregnantPatient) {
        dao.deletePregnantPatient(pregnantPatient);
    }

    @Override
    public PregnantPatient voidPregnantPatient(Integer id) {
        return dao.voidPregnantPatient(id);
    }

    @Override
    public List<PregnantPatient> getAllPregnantPatientByVoided(Boolean voidedIncluded) {
        return dao.getAllPregnantPatientByVoided(voidedIncluded);
    }

    @Override
    public PregnantPatient getPregnantPatientByPregnantNumber(String pregnantNumber) {
        return dao.getPregnantPatientByPregnantNumber(pregnantNumber);
    }

    @Override
    public PregnantPatient getPregnantPatientByHivCareNumber(String hivCareNumber) {
        return dao.getPregnantPatientByHivCareNumber(hivCareNumber);
    }

    /**
     * HIV Service
     */

    @Override
    public List<HivService> getAllHivService() {
        return dao.getAllHivService();
    }

    @Override
    public HivService getHivServiceById(Integer id) {
        return dao.getHivServiceById(id);
    }

    @Override
    public HivService saveHivService(HivService hivService) {
        return dao.saveHivService(hivService);
    }

    @Override
    public void deleteHivService(HivService hivService) {
        dao.deleteHivService(hivService);
    }

//    @Override
//    public HivService voidHivService(Integer id) {
//        return dao.voidHivService(id);
//    }

    @Override
    public List<HivService> getAllHivServiceByVoided(Boolean voidedIncluded) {
        return dao.getAllHivServiceByVoided(voidedIncluded);
    }

    /**
     * Consultations
     */

    @Override
    public Birth saveBirthConsultation(Birth birth) {
        return dao.saveBirthConsultation(birth);
    }

    @Override
    public Prenatal savePrenatalConsultation(Prenatal prenatal) {
        return dao.savePrenatalConsultation(prenatal);
    }

    @Override
    public Postnatal savePostnatalConsultation(Postnatal postnatal) {
        return dao.savePostnatalConsultation(postnatal);
    }

    @Override
    public Consultation getConsultation(Integer id) {
        return dao.getConsultation(id);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return dao.getAllConsultations();
    }

    @Override
    public List<Consultation> getAllConsultationsByDate(Date currentDate, Boolean voided) {
        return dao.getAllConsultationsByDate(currentDate, voided);
    }

    @Override
    public List<ConsultationWithType> getConsultationsByDate(Date currentDate, Boolean voided) {
        return dao.getConsultationsByDate(currentDate, voided);
    }

    @Override
    public List<Consultation> getConsultationsByDate(Date startDate, Date endDate) {
        return dao.getConsultationsByDate(startDate, endDate);
    }

    @Override
    public List<Birth> getAllBirthConsultation() {
        return dao.getAllBirthConsultation();
    }

    @Override
    public List<Prenatal> getAllPrenatalConsultation() {
        return dao.getAllPrenatalConsultation();
    }

    @Override
    public List<Postnatal> getAllPostnatalConsultation() {
        return dao.getAllPostnatalConsultation();
    }

    @Override
    public List<Birth> getBirthConsultationsByDate(Date sDate, Date eDate) {
        return dao.getBirthConsultationsByDate(sDate, eDate);
    }

    @Override
    public List<Prenatal> getPrenatalConsultationsByDate(Date startDate, Date endDate) {
        return dao.getPrenatalConsultationsByDate(startDate, endDate);
    }

    @Override
    public List<Postnatal> getPostnatalConsultationsByDate(Date sDate, Date eDate) {
        return dao.getPostnatalConsultationsByDate(sDate, eDate);
    }

    @Override
    public Birth getBirthConsultation(Integer id) {
        return dao.getBirthConsultation(id);
    }

    @Override
    public Prenatal getPrenatalConsultation(Integer id) {
        return dao.getPrenatalConsultation(id);
    }

    @Override
    public Postnatal getPostnatalConsultation(Integer id) {
        return dao.getPostnatalConsultation(id);
    }

    @Override
    public List<Prenatal> getPrenatalConsultationsByPregnantPatientNumber(String pregnantNumber) {
        return dao.getPrenatalConsultationsByPregnantPatientNumber(pregnantNumber);
    }

    @Override
    public List<Postnatal> getPostnatalConsultationsByPregnantPatientNumber(String pregnantNumber) {
        return dao.getPostnatalConsultationsByPregnantPatientNumber(pregnantNumber);
    }

    @Override
    public MotherFollowup getCurrentMotherFollowupByPregnantPatient(PregnantPatient pregnantPatient) {
        return dao.getCurrentMotherFollowupByPregnantPatient(pregnantPatient);
    }

    @Override
    public void removeMotherFollowupVisit(MotherFollowupVisit motherFollowupVisit) {
        dao.removeMotherFollowupVisit(motherFollowupVisit);
    }

    @Override
    public void removeMotherFollowup(MotherFollowup motherFollowup) {
        dao.removeMotherFollowup(motherFollowup);
    }

    @Override
    public MotherFollowup getMotherFollowupById(Integer motherFollowupId) {
        return dao.getMotherFollowupById(motherFollowupId);
    }

    @Override
    public MotherFollowupVisit getMotherFollowUpVisitById(Integer id) {
        return dao.getMotherFollowUpVisitById(id);
    }

    @Override
    public MotherFollowup saveMotherFollowup(MotherFollowup motherFollowup) {
        return dao.saveMotherFollowup(motherFollowup);
    }

    @Override
    public MotherFollowupVisit saveMotherFollowupVisit(MotherFollowupVisit motherFollowupVisit) {
        return dao.saveMotherFollowupVisit(motherFollowupVisit);
    }

    @Override
    public MotherFollowupVisit getPregnantPatientFollowupByDate(Integer pregnantPatientId, Date visitDate) {
        return dao.getPregnantPatientFollowupByDate(pregnantPatientId, visitDate);
    }

    @Override
    public MotherFollowupVisit getEarlierPregnantPatientFollowupVisitForFollowup(Integer motherFollowupId) {
        return dao.getEarlierPregnantPatientFollowupVisitForFollowup(motherFollowupId);
    }

    @Override
    public Child getChildByFollowupNumber(String childFollowupNumber) {
        return dao.getChildByFollowupNumber(childFollowupNumber);
    }

    @Override
    public List<PregnantPatientToFollow> getPregnantPatientFollowupList() {
        return dao.getPregnantPatientFollowupList();
    }

    @Override
    public Patient getPatientByIdentifier(String identifier) {
        return dao.getPatientByIdentifier(identifier);
    }

    @Override
    public List<MotherFollowupCurrentlyOn> getMotherFollowupCurrentlyOnList(Date startDate, String status, Integer pregnancyOutcome, Date endDate) {
        return dao.getMotherFollowupCurrentlyOnList(startDate, status, pregnancyOutcome, endDate);
    }

    @Override
    public List<MotherFollowupCurrentlyOn> getMotherFollowupList(Date startDate, Date endDate, String status, Integer pregnancyOutcome, String startOrEnd) {
        return dao.getMotherFollowupList(startDate, endDate, status, pregnancyOutcome, startOrEnd);
    }

    @Override
    public List<Child> getChildList() {
        return dao.getChildList();
    }

    @Override
    public Child getChildById(Integer childId) {
        return dao.getChildById(childId);
    }

    @Override
    public Child saveChild(Child child) {
        return dao.saveChild(child);
    }

    @Override
    public ChildFollowup getChildFollowupById(Integer childFollowupId) {
        return dao.getChildFollowupById(childFollowupId);
    }

    @Override
    public ChildFollowupVisit getChildFollowupVisitById(Integer childFollowupVisitId) {
        return dao.getChildFollowupVisitById(childFollowupVisitId);
    }

    @Override
    public ChildFollowup saveChildFollowup(ChildFollowup childFollowup) {
        return dao.saveChildFollowup(childFollowup);
    }

    @Override
    public ChildFollowupVisit saveChildFollowupVisit(ChildFollowupVisit childFollowupVisit) {
        return dao.saveChildFollowupVisit(childFollowupVisit);
    }

    @Override
    public ChildFollowupVisit getChildFollowupVisitByChildAndDate(Integer childId, Date visitDate) {
        return dao.getChildFollowupVisitByChildAndDate(childId, visitDate);
    }

    @Override
    public List<ChildFollowupVisit> getChildFollowupVisitByChild(Integer childId) {
        return dao.getChildFollowupVisitByChild(childId);
    }

    @Override
    public void deleteChildFollowupVisit(ChildFollowupVisit childFollowupVisit) {
        dao.deleteChildFollowupVisit(childFollowupVisit);
    }

    @Override
    public List<ChildFollowupTransformer> getChildFollowupList(String status, Date startDate, Date endDate) {
        return dao.getChildFollowupList(status, startDate, endDate);
    }

    @Override
    public void deleteChildFollowup(ChildFollowup childFollowup) {
        dao.deleteChildFollowup(childFollowup);
    }

    @Override
    public List<MotherFollowupVisit> getMotherFollowupVisitByPatientAndFollowup(MotherFollowup motherFollowup) {
        return dao.getMotherFollowupVisitByPatientAndFollowup(motherFollowup);
    }

    @Override
    public Relationship getChildRelationship(Patient mother, Patient patient) {
        return dao.getChildRelationship(mother, patient);
    }

    @Override
    public Consultation getPatientConsultationByDate(Integer pregnantPatientId, Date consultationDate) {
        return dao.getPatientConsultationByDate(pregnantPatientId, consultationDate);
    }

    @Override
    public List<MotherFollowupAppointment> getPregnantPatientsAppointment() {
        return dao.getPregnantPatientsAppointment();
    }

    @Override
    public List<MotherFollowupAppointment> getPregnantPatientsAppointmentMissed() {
        return dao.getPregnantPatientsAppointmentMissed();
    }

    @Override
    public List<ChildFollowupAppointment> getChildByAppointment() {
        return dao.getChildByAppointment();
    }

    @Override
    public List<ChildFollowupAppointment> getChildByAppointmentMissed() {
        return dao.getChildByAppointmentMissed();
    }

    @Override
    public List<ChildFollowupAppointment> getChildByPcrAppointment(String pcrParams, Integer pcrType) {
        return dao.getChildByAppointmentPcr(pcrParams, pcrType);
    }

    @Override
    public Boolean isDead(Patient patient) {
        return dao.isDead(patient);
    }

    @Override
    public Boolean isTransferred(Patient patient) {
        return dao.isTransferred(patient);
    }

    @Override
    public Boolean isDeclaredNegative(Patient patient) {
        return dao.isDeclaredNegative(patient);
    }

    @Override
    public List<ReportingIndicator> getAllIndicators() {
        return dao.getAllIndicators();
    }

    @Override
    public List<ReportingIndicator> getAllIndicators(Boolean includeVoided) {
        return dao.getAllIndicators(includeVoided);
    }

    @Override
    public ReportingIndicator getIndicatorById(Integer indicatorId) {
        return dao.getIndicatorById(indicatorId);
    }

    @Override
    public ReportingIndicator saveReportingIndicator(ReportingIndicator indicator) {
        return dao.saveReportingIndicator(indicator);
    }

    @Override
    public Boolean removeIndicator(Integer indicatorId) {
        return dao.removeIndicator(indicatorId);
    }

    @Override
    public ReportingIndicator voidIndicator(Integer indicatorId) {
        return dao.voidIndicator(indicatorId);
    }

    @Override
    public ReportingIndicator getIndicatorByUuid(String uuid) {
        return dao.getIndicatorByUuid(uuid);
    }

    @Override
    public List<ReportingDataset> getAllDatasets() {
        return dao.getAllDatasets();
    }

    @Override
    public List<ReportingDataset> getAllDatasets(Boolean includeVoided) {
        return dao.getAllDatasets(includeVoided);
    }

    @Override
    public ReportingDataset getDatasetById(Integer datasetId) {
        return dao.getDatasetById(datasetId);
    }

    @Override
    public ReportingDataset saveReportingDataset(ReportingDataset dataset) {
        return dao.saveReportingDataset(dataset);
    }

    @Override
    public Boolean removeDataset(Integer datasetId) {
        return dao.removeDataset(datasetId);
    }

    @Override
    public ReportingDataset voidDataset(Integer datasetId) {
        return dao.voidDataset(datasetId);
    }

    @Override
    public List<ReportingReport> getAllReports() {
        return dao.getAllReports();
    }

    @Override
    public List<ReportingReport> getAllReports(Boolean includeVoided) {
        return dao.getAllReports(includeVoided);
    }

    @Override
    public ReportingReport getReportById(Integer reportId) {
        return dao.getReportById(reportId);
    }

    @Override
    public ReportingReport saveReportingReport(ReportingReport report) {
        return dao.saveReportingReport(report);
    }

    @Override
    public Boolean removeReport(Integer reportId) {
        return dao.removeReport(reportId);
    }

    @Override
    public ReportingReport voidReport(Integer reportId) {
        return dao.voidReport(reportId);
    }

    @Override
    public List<ReportingTemplate> getAllTemplates() {
        return dao.getAllTemplates();
    }

    @Override
    public List<ReportingTemplate> getAllTemplates(Boolean includeVoided) {
        return dao.getAllTemplates(includeVoided);
    }

    @Override
    public ReportingTemplate getTemplateById(Integer templateId) {
        return dao.getTemplateById(templateId);
    }

    @Override
    public ReportingTemplate getTemplateByName(String name) {
        return dao.getTemplateByName(name);
    }

    @Override
    public ReportingTemplate saveReportingTemplate(ReportingTemplate template) {
        return dao.saveReportingTemplate(template);
    }

    @Override
    public Boolean removeTemplate(Integer templateId) {
        return dao.removeTemplate(templateId);
    }

    @Override
    public ReportingTemplate voidTemplate(Integer templateId) {
        return dao.voidTemplate(templateId);
    }

    @Override
    public SerializedData getSerializedDataById(Integer id) {
        return dao.getSerializedDataById(id);
    }

    @Override
    public SerializedData getSerializedDataByObjectUuid(String objectUuid) {
        return dao.getSerializedDataByObjectUuid(objectUuid);
    }


    @Override
    public List<SerializedData> getAllSerializedData() {
        return dao.getAllSerializedData();
    }

    @Override
    public SerializedData saveSerializedData(SerializedData serializedData) {
        return dao.saveSerializedData(serializedData);
    }

    @Override
    public Boolean removeSerializedDataById(Integer id) {
        return dao.removeSerializedDataById(id);
    }

    @Override
    public ReportingReportGeneration getGeneratedReportById(Integer generatedReportId) {
        return dao.getGeneratedReport(generatedReportId);
    }

    @Override
    public String getGeneratedReportXmlString(Date startDate, Date endDate, Integer reportId, String location) {
        return dao.getGeneratedReportXmlString(startDate, endDate, reportId, location);
    }

    @Override
    public ReportingReportGeneration saveGenerationReport(ReportingReportGeneration reportingReportGeneration) {
        return dao.saveGenerationReport(reportingReportGeneration);
    }

    @Override
    public List<ReportingReportGeneration> getAllGeneratedReport(Boolean includeVoided) {
        return dao.getAllGeneratedReport(includeVoided);
    }

    @Override
    public ReportingDataset getDatasetByUuid(String uuid) {
        return dao.getDatasetByUuid(uuid);
    }

    @Override
    public Boolean removeGeneratedReport(Integer delId) {
        return dao.removeGeneratedReport(delId);
    }

    @Override
    public Location getLocationByName(String name) {
        return dao.getLocationByName(name);
    }

    @Override
    public ReportingIndicator getIndicatorByName(String name) {
        return dao.getIndicatorByName(name);
    }

    @Override
    public ReportingIndicator getIndicatorByCode(String code) {
        return dao.getIndicatorByCode(code);
    }

    @Override
    public ReportingReportGeneration getGeneratedReportByName(String name) {
        return dao.getGeneratedReportByName(name);
    }

    @Override
    public ReportingReportGeneration getGeneratedReportByNameAndReportId(String name, Integer reportId) {
        return dao.getGeneratedReportByNameAndReportId(name, reportId);
    }

    @Override
    public List<ChildPcrResultWaitingTransformer> getChildPcrResultWaiting() {
        return dao.getChildPcrResultWaiting();
    }

    @Override
    public PregnantPatient getPregnantPatientByUuid(String s) {
        return dao.getPregnantPatientByUuid(s);
    }

    @Override
    public void removePregnantPatient(PregnantPatient pregnantPatient) {
        dao.removePregnantPatient(pregnantPatient);
    }

    @Override
    public ChildFollowup getChildFollowupByUuid(String s) {
        return dao.getChildFollowupByUuid(s);
    }

    @Override
    public Birth getBirthConsultationByUuid(String uuid) {
        return dao.getBirthConsultationByUuid(uuid);
    }

    @Override
    public Prenatal getPrenatalConsultationByUuid(String uuid) {
        return dao.getPrenatalConsultationByUuid(uuid);
    }

    @Override
    public Postnatal getPostnatalConsultationByUuid(String uuid) {
        return dao.getPostnatalConsultationByUuid(uuid);
    }

    @Override
    public HivService getHivServiceByUuid(String uuid) {
        return dao.getHivServiceByUuid(uuid);
    }

    @Override
    public ChildFollowupVisit getChildFollowupVisitByUuid(String uuid) {
        return dao.getChildFollowupVisitByUuid(uuid);
    }

    @Override
    public MotherFollowup getMotherFollowupByUuid(String uuid) {
        return dao.getMotherFollowupByUuid(uuid);
    }

    @Override
    public MotherFollowupVisit getMotherFollowupVisitByUuid(String uuid) {
        return dao.getMotherFollowupVisitByUuid(uuid);
    }

    @Override
    public Child getChildByUuid(String uuid) {
        return dao.getChildByUuid(uuid);
    }

    @Override
    public void removeChild(Child child) {
        dao.removeChild(child);
    }

}
