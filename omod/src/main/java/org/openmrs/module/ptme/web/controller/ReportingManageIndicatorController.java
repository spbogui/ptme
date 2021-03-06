package org.openmrs.module.ptme.web.controller;

import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.ptme.ReportingIndicator;
import org.openmrs.module.ptme.api.PreventTransmissionService;
import org.openmrs.module.ptme.forms.GetIndicatorFromFrom;
import org.openmrs.module.ptme.forms.IndicatorForm;
import org.openmrs.module.ptme.forms.validators.IndicatorFormValidator;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ReportingManageIndicatorController {

    private PreventTransmissionService getPreventTransmissionService() {
        return Context.getService(PreventTransmissionService.class);
    }

    @ModelAttribute("chosenLocation")
    public Location getChosenLocation(Integer locationId){
        if (locationId != null) {
            return Context.getLocationService().getLocation(locationId);
        } else {
            return Context.getLocationService().getLocation(Context.getAdministrationService().getGlobalProperty("default_location"));
        }
    }

    @RequestMapping(value = "/module/ptme/reportIndicator.form")
    public void manage(HttpServletRequest request,
                       @RequestParam(required = false, defaultValue = "") String add,
                       @RequestParam(required = false, defaultValue = "0") Integer delId,
                       @RequestParam(required = false, defaultValue = "") Integer indicatorId,
                       ModelMap modelMap) {

        if (!Context.isAuthenticated()){
            return;
        }

        HttpSession session = request.getSession();

        String mode = "list";

        if (!add.isEmpty()){
            mode = "form";
        }

        if (indicatorId != null){
            if (getPreventTransmissionService().getIndicatorById(indicatorId) != null )
                mode = "form";
        }

        if (delId != 0) {
            ReportingIndicator reportingIndicator = getPreventTransmissionService().getIndicatorById(delId);
            if (reportingIndicator != null) {
                getPreventTransmissionService().voidIndicator(delId);
                session.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Indicateur supprimé avec succès !");
            }
        }

        if (mode.equals("form")) {
            IndicatorForm indicatorForm = new IndicatorForm();

            if (indicatorId != null) {
                indicatorForm.setIndicator(getPreventTransmissionService().getIndicatorById(indicatorId));
            }

            modelMap.addAttribute("indicatorForm", indicatorForm);

        }

        if (mode.equals("list")){
            GetIndicatorFromFrom getIndicatorFromFrom = new GetIndicatorFromFrom();
            modelMap.addAttribute("getIndicatorFromFrom", getIndicatorFromFrom);
            modelMap.addAttribute("indicators", getPreventTransmissionService().getAllIndicators(false));
        }

        //modelMap.addAttribute("pageName", "Indicator.jsp");
        modelMap.addAttribute("mode", mode);
    }

    @RequestMapping(value = "/module/ptme/reportIndicator.form", method = RequestMethod.POST)
    public String onSubmitIndicator(HttpServletRequest request,
                                  ModelMap modelMap,
                                  @RequestParam(required = false, defaultValue = "") Integer indicatorId,
                                  IndicatorForm indicatorForm,
                                  BindingResult result) {

        if (!Context.isAuthenticated()){
            return null;
        }

        new IndicatorFormValidator().validate(indicatorForm, result);

        if (result.hasErrors()) {
            modelMap.addAttribute("mode", "form");
            return null;
        }

//        if(!result.hasErrors()) {
            HttpSession session = request.getSession();

            // Boolean hasErrors = false;

            ReportingIndicator indicator = null;
            if (indicatorForm.getIndicatorId() == null) {
                indicator = indicatorForm.getIndicator(new ReportingIndicator());
            } else {
                indicator = indicatorForm.getIndicator(getPreventTransmissionService().getIndicatorById(indicatorForm.getIndicatorId()));
            }

            if (getPreventTransmissionService().saveReportingIndicator(indicator) != null) {
                if (indicatorForm.getIndicatorId() != null) {
                    session.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Indicateur mis à jour avec succès !");
                } else {
                    session.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Indicateur sauvegargé avec succès !");
                }
            }

            modelMap.addAttribute("mode", "list");
            return "redirect:/module/ptme/reportIndicator.form";
        /*} else {
            System.out.println("------------------------ Invalid form data -------------------------------/");
            modelMap.addAttribute("mode", "form");
            modelMap.addAttribute("indicatorForm", indicatorFrom);
        }*/

//        return null;
    }

}
