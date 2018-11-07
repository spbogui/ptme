package org.openmrs.module.ptme.forms;

import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.ptme.ReportingReport;
import org.openmrs.module.ptme.ReportingReportGeneration;
import org.openmrs.module.ptme.api.PreventTransmissionService;
import org.openmrs.module.ptme.utils.UsefullFunction;

import java.util.Date;

public class RunReportForm {
    private Integer generationId;
    private String name;
    private Date generationDate;
    private Date reportPeriodStartDate;
    private Date reportPeriodEndDate;
    private Integer reportLocationId;
    private Integer reportId;
    private Boolean saved = false;

    public RunReportForm() {
    }

    public Integer getGenerationId() {
        return generationId;
    }

    public void setGenerationId(Integer generationId) {
        this.generationId = generationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public Date getReportPeriodStartDate() {
        return reportPeriodStartDate;
    }

    public void setReportPeriodStartDate(Date reportPeriodStartDate) {
        this.reportPeriodStartDate = reportPeriodStartDate;
    }

    public Date getReportPeriodEndDate() {
        return reportPeriodEndDate;
    }

    public void setReportPeriodEndDate(Date reportPeriodEndDate) {
        this.reportPeriodEndDate = reportPeriodEndDate;
    }

    public Integer getReportLocationId() {
        return reportLocationId;
    }

    public void setReportLocationId(Integer reportLocationId) {
        this.reportLocationId = reportLocationId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public void getGeneratedReport(ReportingReportGeneration generation) {
        this.setReportId(generation.getGenerationId());
        this.setGenerationDate(generation.getGenerationDate());
        this.setReportPeriodStartDate(generation.getReportPeriodStartDate());
        this.setReportPeriodEndDate(generation.getReportPeriodEndDate());
        this.setReportLocationId(generation.getReportLocation().getLocationId());
        this.setReportId(generation.getReport().getReportId());
        this.setSaved(generation.getSaved());
    }

    public ReportingReportGeneration setGeneratedReport(ReportingReportGeneration generation) {
        generation.setGenerationId(this.getGenerationId());
        generation.setName(this.getName());
        generation.setSaved(this.getSaved());
        generation.setReportPeriodStartDate(this.getReportPeriodStartDate());
        generation.setReportPeriodEndDate(this.getReportPeriodEndDate());
        generation.setGenerationDate(new Date());

        ReportingReport report = Context.getService(PreventTransmissionService.class).getReportById(this.getReportId());
        if (report != null) {
            generation.setReport(report);
        }

        Location location = Context.getLocationService().getLocation(this.getReportLocationId());
        if (location != null) {
            generation.setReportLocation(location);
        }

        if (generation.getCreator() == null){
            generation.setCreator(Context.getAuthenticatedUser());
            generation.setDateCreated(UsefullFunction.formatDateToddMMyyyyhms(new Date()));
        }
        if (this.getGenerationId() != null) {
            generation.setChangedBy(Context.getAuthenticatedUser());
            generation.setDateChanged(UsefullFunction.formatDateToddMMyyyyhms(new Date()));
        }

        if(generation.getVoided()) {
            generation.setVoidedBy(Context.getAuthenticatedUser());
            generation.setDateVoided(UsefullFunction.formatDateToddMMyyyyhms(new Date()));
        }
        return generation;
    }
}