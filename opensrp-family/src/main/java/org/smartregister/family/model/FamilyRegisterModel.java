package org.smartregister.family.model;

import android.util.Log;
import android.util.Pair;

import org.json.JSONObject;
import org.smartregister.clientandeventmodel.Client;
import org.smartregister.clientandeventmodel.Event;
import org.smartregister.configurableviews.ConfigurableViewsLibrary;
import org.smartregister.family.FamilyLibrary;
import org.smartregister.family.contract.FamilyRegisterContract;
import org.smartregister.family.util.JsonFormUtils;
import org.smartregister.family.util.Utils;
import org.smartregister.location.helper.LocationHelper;
import org.smartregister.util.FormUtils;

import java.util.List;
import java.util.Map;

public class FamilyRegisterModel implements FamilyRegisterContract.Model {
    private FormUtils formUtils;

    @Override
    public void registerViewConfigurations(List<String> viewIdentifiers) {
        ConfigurableViewsLibrary.getInstance().getConfigurableViewsHelper().registerViewConfigurations(viewIdentifiers);
    }

    @Override
    public void unregisterViewConfiguration(List<String> viewIdentifiers) {
        ConfigurableViewsLibrary.getInstance().getConfigurableViewsHelper().unregisterViewConfiguration(viewIdentifiers);
    }

    @Override
    public void saveLanguage(String language) {
        // TODO Save Language
        //Map<String, String> langs = getAvailableLanguagesMap();
        //Utils.saveLanguage(Utils.getKeyByValue(langs, language));
    }

    private Map<String, String> getAvailableLanguagesMap() {
        return null;
        //return AncApplication.getJsonSpecHelper().getAvailableLanguagesMap();
    }

    @Override
    public String getLocationId(String locationName) {
        return LocationHelper.getInstance().getOpenMrsLocationId(locationName);
    }

    @Override
    public Pair<Client, Event> processRegistration(String jsonString) {
        return JsonFormUtils.processFamilyRegistrationForm(FamilyLibrary.getInstance().context().allSharedPreferences(), jsonString);
    }

    @Override
    public JSONObject getFormAsJson(String formName, String entityId, String currentLocationId) throws Exception {
        JSONObject form = getFormUtils().getFormJson(formName);
        if (form == null) {
            return null;
        }
        return JsonFormUtils.getFormAsJson(form, formName, entityId, currentLocationId);
    }

    private FormUtils getFormUtils() {
        if (formUtils == null) {
            try {
                formUtils = FormUtils.getInstance(FamilyLibrary.getInstance().context().applicationContext());
            } catch (Exception e) {
                Log.e(FamilyRegisterModel.class.getCanonicalName(), e.getMessage(), e);
            }
        }
        return formUtils;
    }

    public void setFormUtils(FormUtils formUtils) {
        this.formUtils = formUtils;
    }


    @Override
    public String getInitials() {
        return Utils.getUserInitials();
    }
}
